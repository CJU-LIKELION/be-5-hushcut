package package2;

import java.util.List;
import java.util.Scanner;
import policy.LionSubmissionPolicy;
import policy.StaffSubmissionPolicy;
import policy.SubmissionPolicy;
import role.Lion;
import role.Role;
import role.Staff;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        MemberRepository memberRepository = chooseRepository();
        MemberService memberService = new MemberService(memberRepository);

        boolean running = true;

        while (running) {
            printMenu();
            int menu = readInt("선택: ");

            switch (menu) {
                case 1 -> registerMember(memberService);
                case 2 -> printAllMembers(memberService);
                case 3 -> searchMember(memberService);
                case 4 -> running = false;
                default -> System.out.println("잘못된 메뉴입니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }

    private static MemberRepository chooseRepository() {
        System.out.println("저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (데모 데이터)");

        int menu = readInt("선택: ");
        if (menu == 2) {
            return new MockMemberRepository();
        }

        return new MemoryMemberRepository();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) =====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 검색");
        System.out.println("4. 종료");
    }

    private static void registerMember(MemberService memberService) {
        Role member = createMemberFromInput();
        boolean registered = memberService.register(member);

        if (registered) {
            System.out.println("등록 완료: " + member.getName());
        } else {
            System.out.println("이미 존재하는 이름입니다.");
        }
    }

    private static Role createMemberFromInput() {
        int roleType = readInt("역할 선택 (1: 아기사자, 2: 운영진): ");
        System.out.println("정보 입력");
        String name = readLine("이름: ");
        String major = readLine("전공: ");
        int generation = readInt("기수: ");
        String part = readLine("파트: ");
        String studentId = readLine("학번: ");

        if (roleType == 1) {
            return new Lion(name, major, generation, part, studentId);
        }

        return new Staff(name, major, generation, part, studentId);
    }

    private static void printAllMembers(MemberService memberService) {
        List<Role> members = memberService.findAllMembers();

        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        System.out.println("===== 전체 멤버 목록 =====");
        for (Role member : members) {
            printMember(member);
        }
    }

    private static void searchMember(MemberService memberService) {
        String name = readLine("검색할 이름: ");
        Role member = memberService.findMemberByName(name);

        if (member == null) {
            System.out.println("해당 이름의 멤버가 없습니다.");
            return;
        }

        System.out.println("===== 검색 결과 =====");
        printMember(member);
    }

    private static void printMember(Role member) {
        SubmissionPolicy policy = member instanceof Lion
                ? new LionSubmissionPolicy()
                : new StaffSubmissionPolicy();
        String submitMessage = policy.canSubmit(member) ? "가능" : "불가능";

        System.out.println(member.getInfo() + " | 과제 제출 가능: " + submitMessage);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = SCANNER.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    private static String readLine(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }
}
