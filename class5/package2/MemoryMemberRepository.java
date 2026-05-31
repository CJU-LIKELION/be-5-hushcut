package package2;

import java.util.ArrayList;
import java.util.List;
import role.Role;

public class MemoryMemberRepository implements MemberRepository {
    private final List<Role> members = new ArrayList<>();

    @Override
    public boolean save(Role member) {
        if (existsByName(member.getName())) {
            return false;
        }

        members.add(member);
        return true;
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(members);
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
