package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

    /* 설명. @Qualifier와 마찬가지로 @Primary보다 우선순위 높게 우리가 원하는 빈 이름(id)으로
        하나의 빈을 주입받을 수 있다. */
//    @Resource(name = "charmander")
//    private Pokemon pokemon;
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    /* 질문. List로 bean을 가져오면 어차피 Pokemon 타입의 모든 빈을 담게되는데, Resource를 사용하는 이유가 뭔가요?? */
    @Resource
    private List<Pokemon> pokemonList;
    public void pokemonAttack(){
        pokemonList.forEach(Pokemon::attack);
    }
}
