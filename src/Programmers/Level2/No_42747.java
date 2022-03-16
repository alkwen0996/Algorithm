package Programmers.Level2;

import java.util.Arrays;

public class No_42747 {
    public static void main(String[] args) {
        int[] citations = {20, 21, 22, 23};

        int result = solution(citations);
        System.out.println(result);
    }

    private static int solution(final int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));

        int answer = 0;
        int h = citations.length;

        if (citations[0] > citations.length) {
            return citations.length;
        }

        while (h-- > 0) {
            int citationCount = 0;

            for (final int citation : citations) {
                if (citation >= h) {
                    citationCount++;
                }
            }

            if (h <= citationCount) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
