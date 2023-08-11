import java.util.Arrays;
import java.util.Comparator;

class Solution {
     public int solution(final int[][] targets) {
        int answer = 0;
        int end = 0;

        Arrays.sort(targets, Comparator.comparingInt(target -> target[1]));

        for (final int[] target : targets) {

            if (target[0] < end) {
                continue;
            }

            end = target[1];
            answer++;
        }

        return answer;
    }
}