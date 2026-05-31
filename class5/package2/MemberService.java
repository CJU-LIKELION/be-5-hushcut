package package2;

import java.util.List;
import role.Role;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean register(Role member) {
        if (memberRepository.existsByName(member.getName())) {
            return false;
        }

        return memberRepository.save(member);
    }

    public List<Role> findAllMembers() {
        return memberRepository.findAll();
    }

    public Role findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}
