package Programmers.Level1;

import java.util.Arrays;

public class Prg_42748 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = solution(array, commands);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] splitArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(splitArray);

            answer[i] = splitArray[commands[i][2] - 1];
        }

        return answer;
    }
}
