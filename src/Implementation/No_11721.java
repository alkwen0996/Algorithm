package Implementation;

import java.util.Locale;
import java.util.Scanner;

public class No_11721 {
    private static final String PATTERN = "[a-zA-Z]*";

    public static void main(String[] args) {
        String input = inputData();
        int StringLength = input.length();
        System.out.println("StringLength: "+StringLength);
        int printCount = StringLength / 10;
        System.out.println("printCount: "+printCount);
        int lastLineLength = StringLength % 10;
        System.out.println("lastLineLength: "+lastLineLength);

        if (StringLength < 10)
            System.out.println(input);

        for (int i = 0 ; i <= printCount ; i++){
            if(lastLineLength==0)
                System.out.println(input.substring(i,i+10));
            if(lastLineLength>0)
                System.out.println(input.substring(i,i+10));
            if(input.length()<10)
                System.out.println(input);

            input = input.substring(i+10);
            System.out.println("input: "+input);
        }

    }

    private static String inputData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean flag = input.matches(PATTERN);
        if (!flag && input.length() < 100 && input.length() > 0) {
            try {
                throw new Exception("영어 대소문자만 입력 가능합니다.");
            } catch (Exception e) {
                e.printStackTrace();
                inputData();
            }
        }
        return input;
    }

}
