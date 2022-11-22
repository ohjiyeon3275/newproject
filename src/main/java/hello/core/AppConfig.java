package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiccountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /**
     * @생성자주입
     */

    public MemberService memberService () {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new FixDiccountPolicy(), new MemoryMemberRepository());
    }
}
