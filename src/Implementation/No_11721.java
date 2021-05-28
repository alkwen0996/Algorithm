package Implementation;

import java.util.Scanner;

public class No_11721 {
    private static final String PATTERN = "[a-zA-Z]*";

    public static void main(String[] args) {
        String input = inputData();
        int StringLength = input.length();

        if (StringLength <= 10)
            System.out.println(input);

        if (StringLength > 10) {
            int idx = 0;
            while (StringLength > 10) {
                System.out.println(input.substring(idx, idx + 10));
                input = input.substring(idx + 10, StringLength);
                StringLength -= 10;
            }
            System.out.println(input);
        }
    }

    private static String inputData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean flag = input.matches(PATTERN);
        if (!flag && input.length() <= 100 && input.length() > 0) {
            try {
                throw new Exception("영어 대소문자만 입력 가능합니다.");
            } catch (Exception e) {
                e.printStackTrace();
                input = inputData();
            }
        }
        return input;
    }

}
