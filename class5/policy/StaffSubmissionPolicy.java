package policy;

import role.Role;
import role.Staff;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit(Role role) {
        return role instanceof Staff;
    }
}
