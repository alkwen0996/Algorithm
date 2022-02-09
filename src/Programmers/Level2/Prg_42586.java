package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prg_42586 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = solve(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(final int[] progresses, final int[] speeds) {
        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int dayCount = 0;

            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                dayCount++;
            }

            queue.add(dayCount);
        }

        final List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int dayCount = queue.poll();
            int distributionCount = 1;

            while (!queue.isEmpty() && dayCount >= queue.peek()) {
                distributionCount++;
                queue.poll();
            }

            answer.add(distributionCount);
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}
