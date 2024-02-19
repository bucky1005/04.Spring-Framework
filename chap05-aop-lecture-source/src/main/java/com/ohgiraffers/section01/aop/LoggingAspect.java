package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    /* 설명. 타겟 클래스의 메소드에서 Advise를 적용할 수 있는 지점들을 조인포인트(joinPoint)라고 한다.
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
    /* 설명. target을 지정해놓은 코드(Pointcut) */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){ }

    /* 설명 1. Before Advice */
    /* 설명. 매개변수로 쓰인 JoinPoint
        pointCut으로 지정된(패치된) 조인 포인트
     */
    /* 메모. ~~Service 클래스 안에있는 모든 메소드들의 시작 전에 logBefore를 먼저 수행 */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Before Advice 동작");
        /* 메모. JoinPoint와 PointCut
            Joinpoint: Advice가 적용될 수 있는 위치
            PointCut: Joinpooint 중 에서 Advice가 지정된 위치
            타겟, 타입, 매개변수를 가져올 수 있다.
         */
        System.out.println("Before joinPoint.getTarget(): " + joinPoint.getTarget());               // joinPoint가 지정한 타켓 주소
        System.out.println("Before joinPoint.getSignatrue(): " + joinPoint.getSignature());         // 타겟으로 삼은 메소드
        if(joinPoint.getArgs().length > 0){     // 타겟 메소드의 매개변수가 하나 이상이면
            System.out.println("Before joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);         // 해당 메소드의 매개변수
        }
    }

    /* 설명 2. After Advice */
    @After("LoggingAspect.logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
//        System.out.println("After Advice 동작");
        System.out.println("After joinPoint.getTarget(): " + joinPoint.getTarget());               // joinPoint가 지정한 타켓 주소
        System.out.println("After joinPoint.getSignatrue(): " + joinPoint.getSignature());         // 타겟으로 삼은 메소드
        if(joinPoint.getArgs().length > 0){     // 타겟 메소드의 매개변수가 하나 이상이면
            System.out.println("After joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);         // 해당 메소드의 매개변수
        }
    }

    /* 설명 3. After Returning Advice */
    /* 메모. After 이후에 타겟 메소드가 반환한 값을 확인할 수 있음 */
    /* 설명. PointCut에 해당하는 위치가 담긴 메소드가 같은 클래스에 있으면 클래스 소속을 적지 않아도 된다. */
    /* 설명. returning에 쓰인 이름이 반환값이 넘어오는 매개변수명과 일치해야 한다.(result) */
    @AfterReturning(pointcut = "logPointcut()", returning="result")     // returning에 쓰인 이름
    public void logAfterReturning(JoinPoint joinPoint, Object result){  // 반환값이 넘어오는 매개변수명
        System.out.println("After Returning result: " + result);

        /* 설명. AfterReturning Advice를 활용한 반환값 가공도 가능하다. */
        if (result != null && result instanceof List){  // 반환값이 있고, 그 반환값이 List 타입이라면
            ((List<MemberDTO>) result).add(new MemberDTO(3L, "반환값 가공"));
        }
    }

    /* 설명 4. AfterThrowing Advice */
    /* 설명. throwing 속성 값과 매개변수 명이 일치해야 한다 (exception) */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception: " + exception);
    }

    /* 설명 5. Around Advice */
    /* 설명. 이 어드바이스는 조인포인트를 완전히 장악하기 때문에 앞서 살펴본 어드바이스 모두
        Around Advice로 조립할 수 있다.
        심지어 원본 조인 포인트를 언제 실행할지, 실행 자체를 안할지, 계속 실행할지 여부까지도 제어한다.
        Around Advice의 조인포인트 매개변수는 ProccedingJoinPoint로 고정되어 있다.
        JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
        조인 포인트를 진행하는 호출을 잊는 경우가 빈번히 발생하기 때문에 주의해야하며
        가능한 최소한의 요건을 충족하면서도 가장 기능이 약한 어드바이스를 쓰는게 바람직하다.
     */
    /* 메모. Around는 before after 시점을 하나의 메소드에서 동작하도록 처리하여 두 반환값을 가져올 수 있음 */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();        // 해당 시점을 기준으로 타겟 메소드가 동작하여 before, after가 나뉨
        System.out.println("Around After: " + joinPoint.getSignature().getName());

        /* 설명. 실행된 타켓 메소드 반환(다른 어드바이스가 다시 실행할 수 있도록 반환한다.) */
        return result;
    }
}
