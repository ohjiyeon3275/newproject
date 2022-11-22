package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiccountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /**
     * @생성자주입
     */

    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    // 여기서 MemoryMemberRepository 의 중복을 제거

    /**
     * 리팩토링으로 중복을 제거
     */
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new FixDiccountPolicy(), memberRepository());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiccountPolicy();
    }
}
