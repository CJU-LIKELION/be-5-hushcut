package role;

public abstract class Role {
    private final String name;
    private final String major;
    private final int generation;
    private final String part;
    private final String studentId;

    protected Role(String name, String major, int generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getStudentId() {
        return studentId;
    }

    public abstract String getRoleName();

    public String getInfo() {
        return String.format(
                "역할: %s | 이름: %s | 전공: %s | 기수: %d | 파트: %s | 학번: %s",
                getRoleName(),
                name,
                major,
                generation,
                part,
                studentId
        );
    }
}
