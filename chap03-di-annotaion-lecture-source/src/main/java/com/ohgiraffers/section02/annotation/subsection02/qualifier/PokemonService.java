package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /* 설명. @Qualifier를 통해 원하는 bean 이름(id)으로 하나의 빈을 주입 받을 수 있다.
        (@Primary보다 우선순위가 높다.)
     */

    /* 설명. 필드 주입 방식에서 Qualifier 사용 */
//    @Autowired
//    @Qualifier("squirtle")
    private Pokemon pokemon;

    /* 설명. 생성자 주입 방식에서 Qualifier 사용 */
    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
