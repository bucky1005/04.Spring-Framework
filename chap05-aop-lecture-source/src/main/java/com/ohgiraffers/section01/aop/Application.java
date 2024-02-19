package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        /* 설명. ComponentScan 방식으로 경로 설정 */
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("============= select all members =============");
        /* 설명. findAllmembers 호출 이후 AfterReturning Advice가 회원 한명을 추가하므로 아래 예외테스트 시에는 주석할 것 */
        List<MemberDTO> members = memberService.findAllmembers();
        members.forEach(System.out::println);

        System.out.println("============= select one member =============");
        System.out.println(memberService.findMemberBy(1));

        /* 설명. (예외 테스트)2번 인덱스에 해당하는 회원 조회 (AfterThrowing Advice 확인용)
            2번 인덱스 회원은 없으므로(회원이 2명이므로) 에러 발생
         */
//        System.out.println(memberService.findMemberBy(2));

    }
}
