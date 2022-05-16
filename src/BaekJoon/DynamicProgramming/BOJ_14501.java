package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501 {
    private static int maxRevenue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int workingDay = Integer.parseInt(bufferedReader.readLine());

        final List<Consultant> consultantsSchedule = new ArrayList<>();

        for (int i = 0; i < workingDay; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int term = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            consultantsSchedule.add(new Consultant(term, cost));
        }

        int day = 0;
        int sum = 0;

        calculateMaximumRevenue(consultantsSchedule, day, sum);
        System.out.println(maxRevenue);
    }

    private static void calculateMaximumRevenue(final List<Consultant> consultantsSchedule, final int day, final int sum) {
        if (day == consultantsSchedule.size()) {
            maxRevenue = Math.max(maxRevenue, sum);

            return;
        }

        if (day > consultantsSchedule.size()) {
            return;
        }

        calculateMaximumRevenue(consultantsSchedule, day + 1, sum);
        calculateMaximumRevenue(consultantsSchedule, consultantsSchedule.get(day).nextConsultingDay(day), consultantsSchedule.get(day).sumRevenue(sum));
    }

    private static class Consultant {
        private final int day;
        private final int cost;

        public Consultant(final int term, final int cost) {
            this.day = term;
            this.cost = cost;
        }

        private int nextConsultingDay(final int day) {
            return this.day + day;
        }

        private int sumRevenue(final int sum) {
            return cost + sum;
        }

    }
}
