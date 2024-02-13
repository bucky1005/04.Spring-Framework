package com.ohgiraffers.section01.common;

import java.util.List;

public interface BookDAO {
    List<BookDTO> findAllBook();

    BookDTO searchBookBySequence(int sequence);
    /* 메모. PSA(Portable Service Abstraction)
        BookDAO는 BookImpl을 bean으로 받아오고,
        실제 사용자(서비스 단)는 BookDAOImple의 존재는 알지 못하는 채로 BookDAO 인터페이스까지만 활용한다.
        이러한 타입 은닉을 이용하면 bean으로 활용하던 BookDAOImpl을 다른 것으로 바뀌더라도 사용자는 해당 사실을
        알지 못한채로 BookDAO를 그대로 사용할 수 있다.
     */
}
