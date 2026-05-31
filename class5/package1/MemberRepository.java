package package1;

import java.util.ArrayList;
import java.util.List;
import role.Role;

public class MemberRepository {
    private final List<Role> members = new ArrayList<>();

    public boolean save(Role member) {
        if (existsByName(member.getName())) {
            return false;
        }

        members.add(member);
        return true;
    }

    public List<Role> findAll() {
        return new ArrayList<>(members);
    }

    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}
