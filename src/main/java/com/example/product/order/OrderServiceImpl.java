package com.example.product.order;


import com.example.product.discount.DiscountPolicy;
import com.example.product.member.Member;
import com.example.product.member.MemberRepository;

public class OrderServiceImpl implements OrderService  {    // 구현에 의존하지 않고, 추상화에 의존해야 한다. 인터페이스 설계 원칙
    // DIP: 추상에만 의존해야 함
    // 클라이언트 객체는 실행만 담당해야 함.
    // 프로그래머는 추상화에 의존해야 함. 구체화에 의존하면 안됨.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;    // 인터페이스만 있다.(구현객체는 따로 주입받음.)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
