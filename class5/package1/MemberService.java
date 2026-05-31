package package1;

import java.util.List;
import role.Role;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public boolean register(Role member) {
        return memberRepository.save(member);
    }

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}
