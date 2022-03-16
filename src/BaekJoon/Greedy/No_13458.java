package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_13458 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testPlace = Integer.parseInt(bufferedReader.readLine());
        final List<Integer> examinees = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < testPlace; i++) {
            examinees.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int generalSupervisor = Integer.parseInt(stringTokenizer.nextToken());
        final int deputySupervisor = Integer.parseInt(stringTokenizer.nextToken());

        long result = solution(testPlace, examinees, generalSupervisor, deputySupervisor);
        System.out.println(result);
    }

    private static long solution(final int testPlace, final List<Integer> examinees, final int generalSupervisor, final int deputySupervisor) {
        long totalSupervisor = testPlace;

        for (Integer examinee : examinees) {
            if (generalSupervisor < examinee) {

                totalSupervisor += ((examinee - generalSupervisor) / deputySupervisor);

                if ((examinee - generalSupervisor) % deputySupervisor > 0) {
                    totalSupervisor += 1;
                }
            }
        }

        return totalSupervisor;
    }
}
