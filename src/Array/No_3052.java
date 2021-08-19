package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countInputNumbers = 10;
        int[] inputNumbers = new int[countInputNumbers];
        for (int i = 0; i < countInputNumbers; i++) {
            inputNumbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] divides = divisionInputNumbers(inputNumbers);
        System.out.println(Arrays.stream(divides).distinct().count());
    }

    private static int[] divisionInputNumbers(int[] inputNumbers) {
        int[] divides = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            divides[i] = inputNumbers[i] % 42;
        }
        return divides;
    }
}
