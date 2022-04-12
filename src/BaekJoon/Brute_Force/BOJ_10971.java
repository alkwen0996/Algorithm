package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
    private static int minimumCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(bufferedReader.readLine());

        int[][] world = new int[cityCount][cityCount];
        int[] cities = new int[cityCount];

        for (int i = 0; i < cityCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cities[i] = i;
            // 0 ~ n번째 도시까지 순서대로 방문하는게 첫순열 따라서 첫 순열을 country 배열에 넣어준다.
            // country는 순서를 의미
            // country[i]는 i번째 방문하는 도시

            for (int j = 0; j < cityCount; j++) {
                world[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        do {
            int sum = 0;
            boolean flag = true; // 가능한지 살펴보는 변수 (이동할 수 있는지 확인)

            for (int i = 0; i < cities.length - 1; i++) {
                if (world[cities[i]][cities[i + 1]] == 0) {
                    flag = false;
                } else {
                    sum += world[cities[i]][cities[i + 1]];
                }
            } // 여기까지 돌아오는거 빼고 계산.

            int backToStartCity = world[cities[cities.length - 1]][cities[0]];

            if (flag && backToStartCity != 0) { // flag 가 가능해야하고 마지막지점에서 출발지점으로 돌아오는것이 가능해야한다. (즉 0 이면 안된다.)
                sum += backToStartCity;
                minimumCost = Math.min(sum, minimumCost);
            }
        } while (nextPermutation(cities));

        System.out.println(minimumCost);
    }

    private static boolean nextPermutation(final int[] cities) {
        int index1 = cities.length - 1;
        while (index1 > 0 && cities[index1 - 1] >= cities[index1]) {
            index1--;
        }

        if (index1 <= 0) {
            return false;
        }

        int index2 = cities.length - 1;
        while (cities[index1 - 1] >= cities[index2]) {
            index2--;
        }

        swap(cities, index1, index2);

        index2 = cities.length - 1;
        while (index1 < index2) {
            swap(cities, index1, index2);
            index1++;
            index2--;
        }

        return true;
    }

    private static void swap(final int[] country, final int index1, final int index2) {
        int temp = country[index1];
        country[index1] = country[index2];
        country[index2] = temp;
    }

}
