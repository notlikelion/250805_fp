package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageGen {
    // 실행
    public static void main(String[] args) {
        ImageGen gen = new ImageGen();
        gen.inputData();
    }

    // 빈 리스트
    final private List<String> favoriteList = new ArrayList<>();

    final private Scanner scanner = new Scanner(System.in);

    // 입력 받기
    void inputData() {
        for (int i = 0; i < 3; i++) {
            System.out.print("좋아하는 동물을 입력해주세요 : ");
            String input = scanner.nextLine();
            // trim() -> space, enter 문자열 앞뒤에 제거
            if (input.trim().isEmpty()) {
                System.out.println("제대로 입력해주세요!");
                i--;
                continue;
            }
            favoriteList.add(input);
        }
    }
}
