package step1;

//import java.util.List;
import java.util.*; // java.util이라는 경로(패키지) 아래 있는 클래스들을 모두 가져오겠다 (*)

public class Solution01 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(); // ArrayList는 List는 구현한 친구
        // Array처럼 내부에 순서가 있고, 해당 순서에 따라 index가 부여되고,
        // 타입도 다 동일하고, 근데 '길이 제한'이 명시적으로 주지 않는 이상 알아서 늘어난다.

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("입력해주세요 : ");
            String input = scanner.nextLine();
            if (input.equals("종료")) {
                break;
            }
            stringList.add(input); // add : 추가 (맨 끝에 새롭게 추가)
            System.out.println(stringList);
        }
    }
}
