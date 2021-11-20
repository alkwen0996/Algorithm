package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_10813 {
    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        final Map<Integer, Integer> basket = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            basket.put(i, i);
        }

        for (int i = 1; i <= M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int leftBasket = Integer.parseInt(stringTokenizer.nextToken());
            int rightBasket = Integer.parseInt(stringTokenizer.nextToken());

            int leftBasketBall = basket.get(leftBasket);
            int rightBasketBall = basket.get(rightBasket);

            basket.put(leftBasket, rightBasketBall);
            basket.put(rightBasket, leftBasketBall);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (int key : basket.keySet()) {
            stringBuilder.append(basket.get(key)).append(SPACE);
        }

        System.out.println(stringBuilder);
    }
}
