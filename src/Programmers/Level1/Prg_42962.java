package Programmers.Level1;

import java.util.Arrays;

public class Prg_42962 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        long result = solution(n, lost, reserve);
        System.out.println(result);
    }

    private static long solution(final int n, final int[] lost, final int[] reserve) {
        int[] students = new int[n + 1];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (final int i : lost) {
            students[i]--;
        }

        for (final int i : reserve) {
            students[i]++;
        }

        for (int i = 1; i < students.length; i++) {
            if (students[i] == -1) {
                if (students[i - 1] == 1) {
                    students[i - 1]--;
                    students[i]++;
                } else if (i+1 < students.length && students[i + 1] == 1) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < students.length; i++) {
            if (students[i] > -1) {
                answer++;
            }
        }

        return answer;
    }
}
