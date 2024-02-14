package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 설명. 같은 타입의 빈이 2개 이상일 경우 List 또는 Map과 같은 컬렉션 형태로 주입 받을 수 있다. */

    /* 필기 1. 같은 타입의 빈들을 List 형태로 주입 */
//    private List<Pokemon> pokemonList;
//
//    /* 메모. 포켓몬 타입 bean을 리스트 타입에 전부 가져와서 저장 */
//    @Autowired
//    public PokemonService(List<Pokemon> pokemonList) {
//        this.pokemonList = pokemonList;
//    }
//
//    public void pokemonAttack() {
//        /* 메모. 람다식에서 forEach문에는 반환형이 없는 Consumer 타입의 메소드를 사용할 수 있다. */
//        pokemonList.forEach(Pokemon::attack);
//    }

    /* 필기 2. 같은 타입의 빈들을 Map 형태로 주입 */
    private Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack(){
        /* 설명. key와 value를 매개변수로 받아 출력 후 각 포켓몬이 공격을 수행하는 람다식 */
        pokemonMap.forEach((k, v) -> {
            System.out.println("key = " + k);       // key값: bean 객체의 id
            System.out.println("value = " + v);     // value값: bean 객체의 주소값
//            v.attack();
        });
    }
}
