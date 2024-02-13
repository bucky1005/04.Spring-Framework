package com.ohgiraffers.common;

public class PersonalAccount implements Account{

    /* 설명. final로 선언된 변수는 객체가 생성되기 전까지 반드시 초기화가 되어야 함.
    *   => 생성자를 통해 값을 초기화 */
    private final int bankCode;         // 은행 코드
    private final String accNo;         // 계좌 번호
    private int balance;                // 잔액

    /* 설명. 생성자로 final 변수 값 초기화 */
    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + " 계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {

        String str = "";

        /* 설명. if문을 활용해 0원 이상이 입력된 경우만 입금하도록 Validation 설정 */
        if (money >= 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "금액을 잘못 입력하셨습니다.";
        }

        return str;
    }

    @Override
    public String witDraw(int money) {

        String str = "";

        if (this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요";
        }

        return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
