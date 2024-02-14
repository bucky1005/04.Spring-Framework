package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary        // 기본 bean으로 설정, bean을 따로 지정하지 않으면 자동으로 pikachu bean이 지정됨
public class Pikachu implements Pokemon{
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트");
    }
}
