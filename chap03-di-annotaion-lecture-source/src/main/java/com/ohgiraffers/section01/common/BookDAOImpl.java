package com.ohgiraffers.section01.common;

import com.ohgiraffers.section01.autowired.subsection02.constructor.BookService;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDAOImpl implements BookDAO{

    private Map<Integer, BookDTO> bookList;

    /* 질문. 순환 참조란 무엇인가? */
    /* 답변. 아래 코드에서 subsection02의 bookService와 BookDAOImpl은 생성자 매개변수로 서로의 객체를 받아오는 구조이다.
        이를 순환 참조라고 한다.
        두 객체는 아직 생성되지 않았기 때문에 서로 계속 객체를 내놓으라고 요구만 하면서 순환 참조가 계속 발생한다.
        이로 인해 stack overflow가 발생하며 runtime 시 에러가 발생한다.
        생성자 주입을 사용하면 순환 참조가 발생하는 것을 컴파일 에러에서 잡아준다 => 때문에 생성자 주입을 가장 많이 이용한다.
     */
    /* 설명. 순환 참조 확인용 코드 */
//    private BookService bookService;
//
//    public BookDAOImpl(BookService bookService) {
//        this.bookService = bookService;
//    }

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁겅", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 111222, "칭찬, 고래, 춤", "고래", "고래출판", new Date()));
    }

    @Override
    public List<BookDTO> findAllBook() {
        /* 설명. HashMap의 value 들만 뽑아 ArrayList 형태로 변환(Map -> List) */
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO searchBookBySequence(int sequence) {
        return bookList.get(sequence);
    }
}
