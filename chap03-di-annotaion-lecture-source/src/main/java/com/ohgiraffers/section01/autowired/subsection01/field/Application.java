package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* 설명. (중요!)AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하여
            ComponentScan 개념을 따로 설정 클래스 없이 바로 적용할 수 있다. */
        /* 설명. Scan 범위 내 @Component 계열의 어노테이션이 달려있는 bean을 스캔(BookDAOImple, BookService)
        *  메모. 여기서 BookService 타입의 bean은 BookDAOImpl타입 bean에서 필드 주입을 받는 bean이므로,
        *   반드시 BookDAOImpl의 생성이 선행되어야 한다. */
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookService", BookService.class);

        /* 설명. 전체 도서 목록 조회 후 출력 확인 */
        System.out.println("===== 전체 도서 목록 조회 =====");
        bookService.findAllBook().forEach(System.out::println);

        /* 설명. 도서 번호로 검색 후 출력 확인 */
        System.out.println("===== 도서 번호로 조회 =====");
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));
    }
}
