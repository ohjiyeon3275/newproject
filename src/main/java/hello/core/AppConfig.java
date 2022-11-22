package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiccountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * @생성자주입
     */

    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }

    // 여기서 MemoryMemberRepository 의 중복을 제거

    /**
     * 리팩토링으로 중복을 제거
     */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiccountPolicy();
        return new RateDiscountPolicy();
    }
}
