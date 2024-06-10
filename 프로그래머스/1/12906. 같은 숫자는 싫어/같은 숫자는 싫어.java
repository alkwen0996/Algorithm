import java.util.*;

public class Solution {
    public static Integer[] solution(final int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int lastNumber = arr[0];
        answer.add(lastNumber);

        for (int i = 1; i < arr.length; i++) {
            if (lastNumber == arr[i]) {
                continue;
            }

            answer.add(arr[i]);
            lastNumber = arr[i];
        }

        return answer.toArray(new Integer[0]);
    }
}