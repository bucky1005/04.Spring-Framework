package com.ohgiraffers.common;

/* 설명. 인터페이스
    Account라는 객체가 가져야할 정보(기능) 등의 규칙을 정해놓는 것으로 static final상수와 static 메소드만 선언 가능
    해당 인터페이스를 구현하는 구현클래스가 생성되게 됨.
 */
public interface Account {

    /* 설명. 잔액 조회 */
    String getBalance();

    /* 설명. 입금 */
    String deposit(int money);

    /* 설명. 출금 */
    String witDraw(int money);
}
