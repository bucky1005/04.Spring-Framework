package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAO {
    private final List<MemberDTO> memberlist;

    public MemberDAO(List<MemberDTO> memberlist) {
        memberlist = memberlist;
        memberlist.add(new MemberDTO(1L, "유관순"));
        memberlist.add(new MemberDTO(2L, "홍길동"));
    }

    public List<MemberDTO> findAllmembers(){
        return memberlist;
    }
}
