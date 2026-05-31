package policy;

import role.Role;

public interface SubmissionPolicy {
    boolean canSubmit(Role role);
}
