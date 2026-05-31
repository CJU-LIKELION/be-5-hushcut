package package2;

import java.util.List;
import role.Role;

public interface MemberRepository {
    boolean save(Role member);

    List<Role> findAll();

    Role findByName(String name);

    boolean existsByName(String name);
}
