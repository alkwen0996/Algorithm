package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2389 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(bufferedReader.readLine());

        int fiveBag = inputNumber / 5;
        int threeBag = 0;
        int sugar = inputNumber % 5;

        while (fiveBag >= 0) {
            if (sugar % 3 == 0) {
                threeBag = sugar / 3;
                break;
            }

            fiveBag--;
            sugar += 5;
        }

        if (sugar < 0) {
            System.out.println(-1);
        } else {
            System.out.println(fiveBag + threeBag);
        }

    }

}
