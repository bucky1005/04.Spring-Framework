package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Member;

/* 설명. Account를 관리할 bean 설정을 자바 코드로 작성 */
@Configuration
public class ContextConfiguration {

    /* 설명.  메소드 명이 Bean의 이름이 되므로 의미있게 작성해야한다. */
    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-5678");
    }

    @Bean
    public MemberDTO memberGenerator() {

        /* 설명 1. 생성자 주입
         *   메소드에서 반환한 값을 생성자 주입 */
        return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());

        /* 설명 2. Setter 주입
            메소드에서 반환한 값(Account bean)을 setter 주입한 것 */
//        MemberDTO member = new MemberDTO();
//        member.setSequence(1);
//        member.setName("홍길동");
//        member.setPhone("010-1234-5678");
//        member.setEmail("hong123@gmail.com");
//        member.setPersonalAccount(accountGenerator());
//
//        return member;
    }
}
