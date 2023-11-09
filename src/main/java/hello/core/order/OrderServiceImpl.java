package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //구현체로 생성해서 사용
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책 조회

        return new Order(memberId, itemName, itemPrice, discountPrice); //order 반환을 위함
    }
}
