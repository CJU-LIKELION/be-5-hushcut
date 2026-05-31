package policy;

import role.Lion;
import role.Role;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmit(Role role) {
        return role instanceof Lion;
    }
}
