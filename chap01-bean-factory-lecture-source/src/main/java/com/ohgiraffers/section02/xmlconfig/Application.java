package com.ohgiraffers.section02.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/* 수업목표. xml을 사용하여 bean을 사용하는 방법을 이해 할 수 있다. */
public class Application {
    public static void main(String[] args) {

        /* 질문. 경로를 section02/xmlconfig/spring-context.xml 하면 경로를 찾을 수 없다고 하고,
            section02.xmlconfig/spring-context.xml로 했을 때는 정상 실행되는데 왜 그런건가요 */
        /* 답변. directory 경로를 생성할 때에는 .이 아닌 /로 구분하여 생성해야 한다. (package는 .으로 구분)
        *   directory 만들 때 .으로 구분해서 오류나는 것이므로 새로 만들자! */
        ApplicationContext context = new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");    // 해당 메소드는 resources 폴더를 루트 경로로 인식

        MemberDTO member = (MemberDTO) context.getBean("member");
        System.out.println("member = " + member);
    }
}
