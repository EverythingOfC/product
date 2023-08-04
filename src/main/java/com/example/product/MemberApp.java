package com.example.product;

import com.example.product.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // 어노테이션 기반의 자바 설정 클래스로 스프링 컨테이너를 만듬.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 스프링 컨테이너의 빈 저장소에 있는 Bean이름(메소드명), Bean객체(메소드의 리턴값)을 얻어온다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

 //  *** 스프링 컨테이너의 생성 과정 ***
 //  1. 스프링 컨테이너 생성(어노테이션 기반 자바 설정 클래스를 통해)
 //  2. 스프링 빈 등록
 //  3. 스프링 의존 관계 설정(준비) -> 객체 생성
 //  4. 스프링 의존 관계 설정(완료) -> 의존관계 주입

