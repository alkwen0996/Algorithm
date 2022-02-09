package Programmers.Level2;

import java.util.PriorityQueue;

public class Prg_42626 {
    public static void main(String[] args) {
        final int[] scoville = {1, 2, 3, 9, 10, 12};
        final int k = 7;

        int result = solution(scoville, k);
        System.out.println(result);
    }

    private static int solution(final int[] scoville, final int K) {
        int answer = 0;

        final PriorityQueue<Integer> newScoville = new PriorityQueue<>();

        for (final int j : scoville) {
            newScoville.offer(j);
        }

        while (newScoville.peek() <= K) {
            if (newScoville.size() == 1) {
                return -1;
            }

            int first = newScoville.poll();
            int second = newScoville.poll();

            newScoville.offer(first + (second * 2));

            answer++;
        }

        return answer;
    }
}
