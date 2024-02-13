package com.ohgiraffers.common;

import lombok.*;

/* 설명. lombok을 활용하여 어노테이션으로 생성자 및 getter setter 등을 처리 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int sequence;               // 회원 번호
    private String name;                // 이름
    private String phone;               // 폰번호
    private String email;               // 이메일
    private Account personalAccount;    // 개인 계좌
//    private Account personalAccount = new Account(); 를 생략하기 위해 DI를 사용한다.
}