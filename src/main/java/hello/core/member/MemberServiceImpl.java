package hello.core.member;

public class MemberServiceImpl implements MemberService {

    /**
     * @생성자주입
     * 여기서는 추상회에만 의존입
     */

    private final MemberRepository memberRepository;

    // 여기서 어떤 객체가 들어올지 알수 없음
    // 오직 AppConfig를 통해 결정됨
    // 실행에만 집중할 수 있음
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
