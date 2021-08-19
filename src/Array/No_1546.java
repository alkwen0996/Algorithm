package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No_1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countSubjects = Integer.parseInt(bufferedReader.readLine());
        Double[] scores = new Double[countSubjects];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 0; i < countSubjects; i++) {
            scores[i] = Double.parseDouble(stringTokenizer.nextToken());
        }

        Double result = createNewAverage(scores);
        System.out.println(result);
    }

    private static Double createNewAverage(Double[] scores) {
        Double max = Arrays.stream(scores).max(Comparator.comparingDouble(it -> it)).get();

        return Arrays.stream(scores)
                .map(score -> score / max * 100)
                .collect(Collectors.averagingDouble(it -> it));
    }
}
