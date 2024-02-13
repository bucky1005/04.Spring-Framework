package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* 수업목표. java 코드를 사용하여 bean을 활용하는 방법을 이해할 수 있다. */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfigration.class);

        /* 설명. 모든 bean을 확인하는 코드 */
//        String[] beanNames = context.getBeanDefinitionNames();
//        for(String beanName : beanNames){
//            System.out.println("beanNames: " + beanName);
//        }

        /* 메모. bean을 어떻게 가져올 수 있는지 개념을 설명하기 위한 코드, 실무에서는 이렇게 사용하진 않음 */
        /* 설명 1. (이름 활용) bean의 id(bean의 이름)를 이용해서 bean을 가져오는 방법 */
//        MemberDTO member = (MemberDTO) context.getBean("member");       // getBean으로 가져온 객체는 Object 타입이므로 다운캐스팅하기

        /* 설명 2. (타입 활용) bean의 클래스 메타 정보(bean의 타입)를 전달하여 가져오는 방법 */
//        MemberDTO member = context.getBean(MemberDTO.class);

        /* 설명 3. (이름과 타입 활용) bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 */
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);

    }
}
