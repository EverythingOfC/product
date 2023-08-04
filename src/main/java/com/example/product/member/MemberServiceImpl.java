package com.example.product.member;

public class MemberServiceImpl implements MemberService{    // 어떤 객체가 주입될지는 외부에서 결정한다.
                                                            // 기존은 내부에서 결정했음

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {   // 생성자를 통해서 구현체를 주입받음.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
