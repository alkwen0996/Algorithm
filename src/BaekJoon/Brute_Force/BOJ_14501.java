package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501 {
    private static final List<Schedule> schedules = new ArrayList<>();
    private static int maxRevenue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            schedules.add(new Schedule(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        int day = 0;
        int sum = 0;
        selectConsulting(day, sum, n);

        System.out.println(maxRevenue);
    }

    private static void selectConsulting(int day, int sum, final int n) {
        if (day == n) {
            maxRevenue = Math.max(maxRevenue, sum);

            return;
        }

        if (day > n) {
            return;
        }

        selectConsulting(day + 1, sum, n);
        selectConsulting(schedules.get(day).nextConsultingDay(day), schedules.get(day).sumRevenue(sum), n);
    }

    static class Schedule {
        private final int time;
        private final int cost;

        public Schedule(final int time, final int cost) {
            this.time = time;
            this.cost = cost;
        }

        public int nextConsultingDay(final int day) {
            return day + time;
        }

        public int sumRevenue(final int sum) {
            return cost + sum;
        }

    }
}
