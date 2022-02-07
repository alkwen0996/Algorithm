package Programmers.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prg_42586 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solve(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(final int[] progresses, final int[] speeds) {
        int[] completeFunction = new int[progresses.length];
        int answerIndex = 0;

        for (int i = 0; i < progresses.length; i++) {
            int completeCount = 0;

            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                completeCount++;
            }

            if (progresses[i] >= 100) {
                completeFunction[answerIndex] = completeCount;
                answerIndex++;
            }
        }

        final List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < completeFunction.length; i++) {
            int distributionCount = 1;
            if (completeFunction[i] < 0) {
                continue;
            }

            for (int j = i + 1; j < completeFunction.length; j++) {
                if (completeFunction[i] >= completeFunction[j]) {
                    completeFunction[j] = -1;
                    distributionCount++;
                } else {
                    break;
                }
            }

            answer.add(distributionCount);
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}
