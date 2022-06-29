package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        final List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < n; j++) {
                numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }

        System.out.println(solution(n, numbers));
    }

    private static int solution(final int n, final List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers.get(numbers.size() - n);
    }
}
