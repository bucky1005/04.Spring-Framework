package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {;

    /* 설명. 타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인포인트(joinPoint)라고 한다.
        포인트 컷(point cut)은 여러 조인포인트들에 어드바이스(advice)를 적용할 곳을 지정한 것이다.
        해당 조인 포인트에서 어드바이스가 동작한다.

       설명. <포인트컷 표현식>
        execution([수식어] 리턴타입 [클래스이름].이름[파라미터]
        1. 수식어:
        2. 리턴타입:
        3. 클래스 이름(피키지명 포함) 및 메소드 이름: 클래스이름과 메소드 이름 명시
        4. 파라미터(매개변수): 메소드의 파라미터를 명시
        5. " * " : 16개이면서 모든 값이 올 수 있음
        6. " .. : 0개 이상의 모든 값이 올 수 있음

       설명.
        EX) execution(public Integer com.ohgiraffers.section01.advice.*.*)*))
        => com.ohgiraffes.section.advice 패키지에 속해있는 다음 하위 클래스에 파라미터가 1개인 모든 메소드
        이자 접근 제어자가 public이고 반환형이 Integer인 경우
        execution(* com.ohgiraffers.section01.advice.annotation..stu*(..))
        => com.ohgiraffers.section01.advice 패키지 및 하위 패키지에 속해있고 이름이 stu로 시작하는 파라미터가
        0개 이상인 모든 메소드이며 접근제어자와 반환형은 상관없음

     */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointCut(){ }

    /* 설명. ~~Service 클래스 안에있는 모든 메소드들의 시작 전에 logBefore를 먼저 수행 */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before Advice 동작");
    }
}
