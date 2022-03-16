package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        String inputNumberString = bufferedReader.readLine();
        List<Integer> inputNumbers = new ArrayList<>();

        char [] inputNumbersChar = inputNumberString.toCharArray();
        for (char c : inputNumbersChar) {
            inputNumbers.add(Integer.parseInt(String.valueOf(c)));
        }

        System.out.println(inputNumbers.stream().mapToInt(Integer::intValue).sum());

    }
}
