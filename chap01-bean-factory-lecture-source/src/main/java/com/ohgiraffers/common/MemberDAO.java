package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/* 메모. section03 할 때 생성한 것 */
/* 설명. DAO 클래스는 Data Access Object를 줄인 말로, Repository 계층과 마찬가지로
    java application과 Database를 연동시켜 주기 위한 계층의 클래스로 활용된다.
 */
/* 메모. 조회에서는 DAO를 사용, command 등에서는 Repository를 사용할 예정. (DAO와 Repository는 같은 계층으로 봐도 무방) */

/* 설명. @Repository
    DB와 연동하기 위해 사용되는 클래스에 추가하는 어노테이션으로 계층의 의미를 포함하며, bean으로 관리하기 위한 어노테이션이다.

   메모. Ctrl 누르고 들어가보면 Repository 내부에 @Component가 포함되어 있다.
    이처럼 내부에 @Component가 달린 어노테이션은 bean으로 관리하기 위한 어노테이션이다. */
@Repository
/* 설명. @Component
    클래스의 계층의 의미를 담지 않고(추가적인 기능 없이) 단순히 bean으로 관리하기 위해 사용하는 어노테이션이다 */
//@Component
public class MemberDAO {
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    /* 설명. 회원 조회용 메소드(회원 번호를 받아 해당 회원 객체를 반환) */
    public MemberDTO selcetMember(int sequence) {
        return memberMap.get(sequence);
    }

    /* 설명. 회원 가입용 메소드(추가된 회원 수를 반환) */
    public int insertMember(MemberDTO newMember) {
        int before = memberMap.size();

        memberMap.put(newMember.getSequence(), newMember);

        int after = memberMap.size();

        return after - before;
    }

}
