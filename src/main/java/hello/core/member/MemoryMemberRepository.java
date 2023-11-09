package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //map에 올리기
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //map에서 가져오기
    }
}
