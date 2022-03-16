package BaekJoon.Implementation;

import java.util.Scanner;

public class No_11055 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sequenceSize = scanner.nextInt();

        int[] sequenceArray = new int[sequenceSize];

        for (int i = 0; i < sequenceSize; i++) {
            sequenceArray[i] = scanner.nextInt();
        }

        int max = 0;
        int[] increaseArray = new int[sequenceSize];
        for (int i = 0; i < sequenceSize; i++) {
            increaseArray[i] = 0;
            for (int j = 0; j < i; j++) {
                if (sequenceArray[i] > sequenceArray[j] && increaseArray[j] + 1 > increaseArray[i]) {
                    increaseArray[i] = increaseArray[j] + 1;
                }
            }
            if(max<increaseArray[i]){
                max = increaseArray[i];
            }
        }

        System.out.println(max);

    }
}
