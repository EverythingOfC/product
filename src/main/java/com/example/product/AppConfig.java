package com.example.product;

import com.example.product.discount.DiscountPolicy;
import com.example.product.discount.FixDiscountPolicy;
import com.example.product.discount.RateDiscountPolicy;
import com.example.product.member.MemberRepository;
import com.example.product.member.MemberService;
import com.example.product.member.MemberServiceImpl;
import com.example.product.member.MemoryMemberRepository;
import com.example.product.order.OrderService;
import com.example.product.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {    // 애플리케이션의 설정 정보(실제 동작에 필요한 구현 객체를 생성)
                            // 객체의 생성과 연결을 담당
                            // 앱의 정책이 바뀌어도, 구성 영역의 코드만 바꾸면 됨. 사용 영역은 수정할 필요가 없음
    @Bean   // 스프링 Bean은 기본적으로 메소드 이름으로 등록된다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean   // 빈 이름을 직접 지정해줄 수도 있음
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
// OCP(개방 폐쇄 원칙): 확장에는 열려 있고, 변경에는 닫혀 있는 원칙(구성 영역과 사용 영역으로 분리)
// SRP(단일 책임 원칙): 한 클래스는 하나의 책임만 가져야 한다. ( 구현객체를 연결하고 생성하는 책임은 AppConfig가 담당, 클라이언트 객체는 로직 실행 담당)
// DIP(의존성 주입 원칙):  추상화에 의존, 구체화에 의존 X (구성 영역의 코드만 변경하고, 사용 영역의 코드는 변경하지 않아도 됨)
