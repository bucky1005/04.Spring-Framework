package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    /* 수업목표. Primary Annotation을 활용하고 이해할 수 있다. */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        PokemonService pokemonService = context.getBean("pokemonServicePrimary", PokemonService.class);

        /* 메모. 포켓몬 공격이라는 메소드를 실행, 이때 어떤 포켓몬이 공격할 지는 Service 단에 구현해야 함 */
        pokemonService.pokemonAttack();

    }
}
