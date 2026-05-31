package role;

public class Lion extends Role {
    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part, studentId);
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }
}
