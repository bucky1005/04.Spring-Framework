package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* 설명. section03에서는 ComponentScan과 관련하여 java 클래스와 xml 방식으로 사용하는 방법을 확인 할 것임
*   이 중에서도 java 클래스와 @ComponentScan 방식을 자주 사용하고 있다. */
public class Application {
    public static void main(String[] args) {
        /* 메모. java class의 context를 사용할 땐 AnnotationConfigApplicationContext() 메소드를 사용 */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
    }
}
