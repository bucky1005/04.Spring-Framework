package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/* 수업목표. i18n(internationalization) */
public class Application {
    public static void main(String[] args) {

        /* 설명. i18n 소프트웨어의 국제화(Internationalozation)에서 첫 글자인 I와 마지막 글자인 N 사이에 알파벳 개수 19개)란?
            소프트웨어를 국제화 하기 위해서는 처해야 할 작업이 많이있다.
            1. 3언어, 지역별 번역
            2. OS/Platform별 인코딩
            3. 문자열 치환 방법
            4. 국제화 UI(문자열 크기 변화, 폰트, ,아이콘 등)
            5. 쓰기 방향의 차이
            6. 숫자, 공백, 화폐, 날짜, 주소, 측정 단위 등
            7. 타임존, 섬머타임 등 식
            8. 문자열 정렬 방법

           설명. 우리가 다뤄본 예제는 그 중에 1번이 해당하는 다국어 메세지 처리만 살펴본 것
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MessageKR = context.getMessage("error.404", null, Locale.KOREA);
        String error500MessageKR = context.getMessage("error.500", new Object[]{"여러분", new java.util.Date()}, Locale.KOREA);

        System.out.println("I18N error.404 메세지 = " + error404MessageKR);
        System.out.println("I18N error.500 메세지 = " + error500MessageKR);

        String error404MessageUS = context.getMessage("error.404", null, Locale.US);
        String error500MessageUS = context.getMessage("error.500", new Object[]{"여러분", new java.util.Date()}, Locale.US);

        System.out.println("I18N error.g404 메세지 = " + error404MessageUS);
        System.out.println("I18N error.500 메세지 = " + error500MessageUS);
    }
}
