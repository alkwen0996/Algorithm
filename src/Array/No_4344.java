package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int numberOfPeople = Integer.parseInt(stringTokenizer.nextToken());

            ArrayList<Double> averageList = new ArrayList<>(numberOfPeople);
            while (stringTokenizer.hasMoreTokens()) {
                averageList.add(Double.parseDouble(stringTokenizer.nextToken()));
            }

            Double result = averageScores(averageList, numberOfPeople);
            System.out.println(String.format("%.3f",result) + "%");
        }
    }

    private static Double averageScores(ArrayList<Double> averageList, int numberOfPeople) {
        Double averageScore = averageList.stream()
                .collect(Collectors.averagingDouble(it -> it));

        int count = 0;
        for (Double aDouble : averageList) {
            if (aDouble > averageScore) {
                count++;
            }
        }
        return (((double)count / (double) numberOfPeople)*100);
    }
}
