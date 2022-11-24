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
     * @Bean memberService -> new MemoryMemberRepository()
     * @Bean orderService -> new MemoryMemberRepository()
     *
     * 싱글톤이 깨지는게 아닌가용?
     *
     */

    @Bean
    public MemberService memberService () {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // 여기서 MemoryMemberRepository 의 중복을 제거

    /**
     * 리팩토링으로 중복을 제거
     */
    @Bean
    public MemberRepository memberRepository() {

        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {

        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiccountPolicy();
        System.out.println("AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
