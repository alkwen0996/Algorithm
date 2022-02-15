package Programmers.Level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class No_42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        int[] result = solution(prices);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(final int[] prices) {
        final Queue<Integer> priceTimes = new ArrayDeque<>();


        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int time = 0;

            for (int j = i + 1; j < prices.length; j++) {
                time++;
                if (price > prices[j]) {
                    priceTimes.add(time);
                    break;
                }

                if (j == prices.length - 1) {
                    priceTimes.add(time);
                }
            }

            if (i == prices.length - 1) {
                priceTimes.add(time);
            }
        }

        int[] answer = new int[priceTimes.size()];
        int index = 0;

        while(!priceTimes.isEmpty()){
            answer[index] = priceTimes.poll();
            index++;
        }

        return answer;
    }
}
