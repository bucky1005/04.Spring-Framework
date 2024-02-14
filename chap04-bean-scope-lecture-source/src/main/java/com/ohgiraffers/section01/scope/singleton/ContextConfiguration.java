package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    @Scope("singleton")     // 스프링 컨테이너(Spring Container)는 해당 어노테이션을 작성하지 않아도 bean은 기본으로 singleton으로 생성됨
//    @Scope("prototype")   // 사용자 요청이 있을 때마다 bean을 새로운 객체로 생성(life cycle을 다른 주기로 가져갈 수 있다.)
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
