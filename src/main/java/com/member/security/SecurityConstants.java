package com.member.security;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000; //10 days

    public static  final String TOKEN_PREFIX = "Bearer";

    public  static  final  String HEADER_STRING = "Autherization";

    public static final String SIGN_UP_URL = "/members";

    protected  static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
