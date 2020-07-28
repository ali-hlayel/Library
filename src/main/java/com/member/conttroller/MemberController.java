package com.member.conttroller;

import com.member.member.MemberModel;
import com.member.member.Member;
import com.member.exceptions.MemberServiceException;
import com.member.exceptions.ErrorMessages;
import com.member.model.MemberCreateQueryModel;
import com.member.model.MemberUpdateQueryModel;
import com.member.responseModel.MemberResponseModel;
import com.member.responseModel.OperationStatusModel;
import com.member.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping
    public List<MemberResponseModel> getBooks(@RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<MemberResponseModel> returnValue = new ArrayList<>();
        List<Member> books = memberService.getMembers(page, limit);
        ModelMapper modelMapper = new ModelMapper();
        for (Member book : books) {
            returnValue.add(modelMapper.map(book, MemberResponseModel.class));
        }
        return returnValue;
    }

    @GetMapping(path = "/{id}")
    public MemberResponseModel getBook(@PathVariable long id) {
        Member member = memberService.getMemberById(id);
        ModelMapper modelMapper = new ModelMapper();
        MemberResponseModel returnValue = modelMapper.map(member, MemberResponseModel.class);
        Link memberLink = WebMvcLinkBuilder.linkTo(MemberController.class).slash(id).withRel("members");
        return returnValue;
    }

    @PostMapping
    public MemberResponseModel createMember(@RequestBody MemberCreateQueryModel memberCreateQueryModel) {
        if (memberCreateQueryModel.getFirstName().isEmpty())
            throw new MemberServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        ModelMapper modelMapper = new ModelMapper();
        MemberModel memberModel = modelMapper.map(memberCreateQueryModel, MemberModel.class);
        MemberModel createMemberModel = memberService.createMember(memberModel);
        MemberResponseModel memberResponseModel = modelMapper.map(createMemberModel, MemberResponseModel.class);
        return memberResponseModel;
    }

    @PutMapping(path = "/{id}")
    public EntityModel<MemberResponseModel> updateMember(@PathVariable long id, @RequestBody MemberUpdateQueryModel memberUpdateQueryModel) {
        Member updatedMember = new Member();
        BeanUtils.copyProperties(memberUpdateQueryModel, updatedMember);

        Member updateMemberModel = memberService.updateMember(id, updatedMember);
        ModelMapper modelMapper = new ModelMapper();
        MemberResponseModel returnValue = modelMapper.map(updateMemberModel, MemberResponseModel.class);
        Link memberLink = WebMvcLinkBuilder.linkTo(MemberController.class).slash(id).withRel("members");
        return EntityModel.of(returnValue, memberLink);
    }

    @DeleteMapping(path = "/{id}")
    public OperationStatusModel deleteBook(@PathVariable long id) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName("Delete");
        memberService.deleteMember(id);
        returnValue.setOperationStatus("Done");
        return returnValue;
    }

}
