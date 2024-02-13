package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* 설명. bean으로 관리(ComponentScan의 범위에 포함될 경우) + Service 계층의 의미를 포함 */
@Service
public class BookService {

    /* 설명.
        아래의 세 가지는 ComponentScan 범위 안에 어노테이션들이 달렸을 때 유효하다.
        1. @Service에 의해서 BookService 타입의 BookService bean이 관리된다.
        2. BookDAOImpl에 있는 @Repository에 의해서 bookDAOImpl bean이 관리된다.(BookDAO 타입이기도 하다.)
        3. @Autowired에 의해서 BookDAO 타입의 bean이 BookServicce의 필드인 bookDAO 필드에 주입된다.(대입된다.)
     */
    /* 설명. 필드 주입
    *   필드 주입은 final을 선언할 수 없다. (필드 주입 시 final 선언을 하면 JVM에 의한 null 값으로 초기화 된 후 값이 변하지 않게됨) */
    @Autowired
    private BookDAO bookDAO;        // bookDAO = new BookDAOImpl, CompomentScan 범위 안에 BookDAO 타입의 bean이 있다면 bookDAO에 대입.

    /* 설명. 도서 목록 전체 조회 */
    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    /* 설명. 도서 번호로 도서 조회(Application에서 호출되는 메소드) */
    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.searchBookBySequence(sequence);
    }
}
