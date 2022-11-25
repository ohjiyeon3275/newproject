package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService2")
public class MemberServiceImpl implements MemberService {

    /**
     * @생성자주입
     * 여기서는 추상회에만 의존입
     */

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class) 와 같은 기능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // configuration 테스트용동
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
