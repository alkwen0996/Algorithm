package BaekJoon.Back_Tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14888 {
    public static final int OPERATOR_TYPE_COUNT = 4;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static final int[] operators = new int[OPERATOR_TYPE_COUNT];
    private static int[] numbers;
    private static int N;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solution(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void solution(int number, int index) {
        if (index == N) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        System.out.print("더하기: ");
                        solution(number + numbers[index], index + 1);
                        break;
                    case 1:
                        System.out.print("빼기: ");
                        solution(number - numbers[index], index + 1);
                        break;
                    case 2:
                        System.out.print("곱하기: ");
                        solution(number * numbers[index], index + 1);
                        break;
                    case 3:
                        System.out.print("나누기: ");
                        solution(number / numbers[index], index + 1);
                        break;
                }
                operators[i]++;
            }

        }
    }
}
