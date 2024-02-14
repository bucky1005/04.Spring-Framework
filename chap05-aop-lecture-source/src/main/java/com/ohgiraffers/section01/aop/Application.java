package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        /* 설명. ComponentScan 방식으로 경로 설정 */
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section.aop");

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("============= find all members =============");
        List<MemberDTO> members = memberService.fineAllMembers();
        members.forEach(System.out::println);

        System.out.println("============= select one member =============");
        System.out.println(memberService.fineAllMemberBy(2L));
    }
}
