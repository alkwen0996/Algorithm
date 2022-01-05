package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No_4344 {
    public static final int ONE_HUNDRED = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lineCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int numberOfPeople = Integer.parseInt(stringTokenizer.nextToken());

            List<Double> inputScore = new ArrayList<>(numberOfPeople);
            while (stringTokenizer.hasMoreTokens()) {
                inputScore.add(Double.parseDouble(stringTokenizer.nextToken()));
            }

            Double result = solve(inputScore, numberOfPeople);
            stringBuilder.append(String.format("%.3f", result)).append("%").append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static Double solve(List<Double> inputScore, int numberOfPeople) {
        Double averageScore = inputScore.stream()
                .collect(Collectors.averagingDouble(it -> it));

        long count = inputScore.stream()
                .filter(average -> averageScore < average)
                .count();

        return (((double) count / numberOfPeople) * ONE_HUNDRED);
    }
}
