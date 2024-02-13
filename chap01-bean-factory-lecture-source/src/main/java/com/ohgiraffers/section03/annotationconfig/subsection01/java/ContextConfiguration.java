package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/* 설명. 설정용 클래스도 bean으로 관리되며 이름(bean의 id)을 부여할 수 있다. */
/* 메모. bean의 id를 설정하지 않으면 해당 bean의 아이디는 클래스명으로 자동 설정 된다.(단, 첫글자가 소문자로 바뀜) */
/* 메모. java 방식으로 할 때에는 어노테이션을 붙여서 해당 클래스가 설정용 클래스 임을 명시한다. */
@Configuration("configurationSection03")

/* 설명 1. 단순히 범위 지정만으로 @Component 계열의 어노테이션들을 모두 bean으로 관리하는 경우 */
/* 메모. ()에 Scan할 범위를 지정하면 해당 범위(basePackages)에서 어노테이션을 확인하여 bean이 있는지 스캔한다.
*   해당 어노테이션을 사용하지 않으면 기본적으로 해당 클래스가 위치하는 패키지만 스캔한다. */
//@ComponentScan(basePackages = "com.ohgiraffers")

/* 설명 2. 범위 및 필터를 적용해서 bean을 관리하는 경우(excludeFilters) */
//@ComponentScan(basePackages = "com.ohgiraffers",
//        excludeFilters = {      // 제외하고자 하는 bean을 설정
//                @ComponentScan.Filter(
//
//                    /* 설명 2-1. 타입으로 설정 */
////                    type = FilterType.ASSIGNABLE_TYPE,
////                    classes = {MemberDAO.class}
//
//                    /* 설명 2-2. 어노테이션 종류로 설정 */
//                    type = FilterType.ANNOTATION,
//                    classes = {org.springframework.stereotype.Repository.class}
//                )
//        })

/* 설명 3. 범위 및 필터를 적용해서 bean을 관리하는 경우(includeFilters) */
@ComponentScan(basePackages = {"com.ohgiraffers", "com"},
               useDefaultFilters = false,
               includeFilters = {
                    @ComponentScan.Filter(
                            type = FilterType.ASSIGNABLE_TYPE,
                            classes = {MemberDTO.class}
                    )

               })

/* 설명. (중요!!) @ComponentScan은 필터의 경우 개념 정도만 알아도 되지만 기본적으로 @Configuration 클래스가 위치한
    패키지와 해당 패키지 하위만 Scan 하기 때문에 더 상위 범위나 다른 패키지를 Scan 하기 위해 주로 사용한다. */
public class ContextConfiguration {

}

