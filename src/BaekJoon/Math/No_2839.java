package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2839 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(bufferedReader.readLine());

        int five = inputNumber / 5;
        int three = 0;
        inputNumber %= 5;

        while (five >= 0) {
            if (inputNumber % 3 == 0) {
                three = inputNumber / 3;
                inputNumber %= 3;
                break;
            }
            five--;
            inputNumber += 5;
        }

        if(inputNumber == 0){
            System.out.println(five+three);
        }
        if(inputNumber != 0){
            System.out.println(-1);
        }

    }
}
