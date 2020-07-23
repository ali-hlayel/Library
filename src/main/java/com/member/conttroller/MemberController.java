package com.member.conttroller;

import com.member.member.Member;
import com.member.entity.MemberEntity;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping
    public List<MemberResponseModel> getBooks(@RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<MemberResponseModel> returnValue = new ArrayList<>();
        List<MemberEntity> books = memberService.getMembers(page, limit);
        for (MemberEntity book : books) {
            MemberResponseModel memberResponseModel = new MemberResponseModel();
            BeanUtils.copyProperties(book, memberResponseModel);
            returnValue.add(memberResponseModel);
        }
        return returnValue;
    }

    @GetMapping(path = "/{bookId}")
    public MemberResponseModel getBook(@PathVariable String bookId) {
        Member member = memberService.getMemberByMemberId(bookId);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(member, MemberResponseModel.class);
    }

    @PostMapping
    public MemberResponseModel createBook(@RequestBody MemberCreateQueryModel memberCreateQueryModel) {
        if (memberCreateQueryModel.getFirstName().isEmpty())
            throw new MemberServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberCreateQueryModel, Member.class);
        MemberResponseModel memberResponseModel;
        Member createMember = memberService.createMember(member);
        memberResponseModel = modelMapper.map(createMember, MemberResponseModel.class);
        return memberResponseModel;
    }

    @PutMapping(path = "/{bookId}")
    public MemberResponseModel updateBook(@PathVariable String bookId, @RequestBody MemberUpdateQueryModel memberUpdateQueryModel) {
        if (memberUpdateQueryModel.getFirstName().isEmpty())
            throw new MemberServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        MemberResponseModel memberResponseModel = new MemberResponseModel();
        Member updateMember = memberService.updateMember(bookId, memberUpdateQueryModel);
        BeanUtils.copyProperties(updateMember, memberResponseModel);
        return memberResponseModel;
    }

    @DeleteMapping(path = "/{bookId}")
    public OperationStatusModel deleteBook(@PathVariable String bookId) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName("Delete");
        memberService.deleteMember(bookId);
        returnValue.setOperationStatus("Done");
        return returnValue;
    }

}
