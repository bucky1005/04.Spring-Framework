package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 설명. MemberDTO를 생성하고 반환하는 Bean 객체를 생성하는 코드 */
@Configuration
public class ContextConfigration {
    @Bean(name="member")    // 해당 bean의 이름을 member로 설정
    public MemberDTO getMember(){
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }
}
