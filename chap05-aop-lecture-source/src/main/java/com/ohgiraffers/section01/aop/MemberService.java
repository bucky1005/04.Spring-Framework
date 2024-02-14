package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    /* 설명. 서비스의 다음 계층인 Repo(=DAO)를 주입받음
    *   해당 객체는 처음 받은 후 변경되지 않으므로 final로 선언 */
    private final MemberDAO memberDAO;


    /* 설명. MemberDAO를 생성자 주입으로 받아옴 */
    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public List<MemberDTO> fineAllMembers() {
        return memberDAO.findAllmembers();
    }

    public fineAllMemberBy(long l) {
    }
}
