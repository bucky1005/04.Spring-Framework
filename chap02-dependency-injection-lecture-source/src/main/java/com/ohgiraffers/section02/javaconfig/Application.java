package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* 설명. 자바코드로 작성한 bean을 활용할 때에는 AnnotationConfigApplicationContext() 생성자 사용
        *       xml로 작성한 beab을 활용할 때에는 GenericXmlApplicationContext() 생성자 사용 */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberDTO member = context.getBean(MemberDTO.class);

        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(20000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().witDraw(7000));
        System.out.println(member.getPersonalAccount().getBalance());
    }

}
