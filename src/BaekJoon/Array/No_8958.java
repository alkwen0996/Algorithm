package BaekJoon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(bufferedReader.readLine());

        String [] inputList = new String[lineCount];
        for (int i = 0; i < lineCount; i++ ){
            inputList[i] = bufferedReader.readLine();
        }

        int [] result = createScoreList(inputList);

        for (int j : result) {
            System.out.println(j);
        }
    }

    private static int [] createScoreList(String[] inputList) {

        int [] scores = new int [inputList.length];
        for (int i = 0; i < inputList.length ; i++ ){
            char [] oxList = inputList[i].toCharArray();
            scores[i] = calculateScore(oxList);
        }

        return scores;
    }

    private static int calculateScore(char[] oxList) {
        int sum = 0;
        int count = 0;

        for (char c : oxList) {
            if (c == 'O') {
                count++;
                sum += count;
            }
            if (c == 'X') {
                count = 0;
            }
        }

        return sum;
    }
}
