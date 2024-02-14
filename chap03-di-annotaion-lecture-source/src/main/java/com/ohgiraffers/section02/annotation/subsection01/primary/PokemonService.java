package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    /* 메모. 포켓몬을 주입받기 위해 필드 생성 */
    private Pokemon pokemon;

    /* 설명. @Autowired를 생략하면 매개변수 있는 생성자에 자동으로 작성된다.(자동으로 생성자 주입이 됨)
        현재와 같이 Pokemon 타입의 빈이 2개 이상일 경우 @Primary 어노테이션을 통해 하나의 빈만 주입되게 할 수 있다.
     */

    /* 설명. 생성자 주입(자동) */
    /* 메모. Annotation 방식이 편리하지만 현재 코드만 봐서는 어떤 포켓몬 bean이 해당 메소드를 수행하는지 알 수 없음 */
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
