package Programmers.Level2;

import java.util.Arrays;

public class No_42842 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        int[] result = solution(brown, yellow);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(final int brown, final int yellow) {
        int area = brown + yellow;
        int[] answer = new int[2];

        for (int height = 3; height <= area; height++) {
            int width = area / height;

            if(width < 3){
                continue;
            }

            int yellowArea = (width - 2) * (height - 2);
            int brownArea = area - yellowArea;

            if (yellowArea == yellow && brownArea == brown) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }
}
