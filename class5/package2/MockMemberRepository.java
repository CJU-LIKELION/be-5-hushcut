package package2;

import java.util.ArrayList;
import java.util.List;
import role.Lion;
import role.Role;
import role.Staff;

public class MockMemberRepository implements MemberRepository {
    private final List<Role> members = new ArrayList<>();

    public MockMemberRepository() {
        members.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
        members.add(new Staff("이운영", "경영학과", 13, "기획", "202120212"));
    }

    @Override
    public boolean save(Role member) {
        return !existsByName(member.getName());
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
