package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No_10817 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> numbers = new ArrayList<>();
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while(stringTokenizer.hasMoreTokens()){
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solution(numbers);
        System.out.println(result);
    }

    private static int solution(final List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers.get(1);
    }
}
