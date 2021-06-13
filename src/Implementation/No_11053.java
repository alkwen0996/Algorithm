package Implementation;

import java.util.Scanner;

public class No_11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequence = scanner.nextInt();

        int[] sequenceArray = new int[sequence];
        for (int i = 0; i < sequence; i++) {
            sequenceArray[i] = scanner.nextInt();
        }

        int max = 0;
        int[] dpList = new int[sequence];
        for (int i = 0; i < sequence; i++) {
            dpList[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequenceArray[i] > sequenceArray[j] && dpList[j] + 1 > dpList[i]) {
                    dpList[i] = dpList[j] + 1;
                }
            }
            if (dpList[i] > max) {
                max = dpList[i];
            }
        }
        System.out.println(max);
    }
}
