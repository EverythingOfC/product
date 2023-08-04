package com.example.product.member;

import com.example.product.AppConfig;
import com.example.product.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;


    @BeforeEach // 각 테스트 바로 이전에 실행되는 메소드
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given(값이 주어졌을 때)
        Member member = new Member(1L,"memberA",Grade.VIP);

        // when(이렇게 했을 때)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then(이렇게 나온다.)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
