package NHN_Commerce_CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No_02 {
    public static Scanner scanner = new Scanner(System.in);
    // 손님 N명, 전화번호 M개
    public static void main(String[] args) {
        final int tn = scanner.nextInt(); //테스트케이스의 수를 입력받는다
        for (int caseNum = 1; caseNum <= tn; caseNum++) {   //테스트케이스의 수 만큼 반복 수행한다
            testCase(caseNum);
        }
    }

    private static void testCase(final int caseNum) {
        final int N = scanner.nextInt();
        final int M = scanner.nextInt();
        final List<Integer> customers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            customers.add(scanner.nextInt());
        }

        int result = solve(customers);
        System.out.println(result);
    }

    private static int solve(final List<Integer> customers) {

        return 0;
    }
}
