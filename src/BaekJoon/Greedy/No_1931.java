package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1931 {
    static final List<Conference> conferences = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            conferences.add(new Conference(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        sortByMeetingStartTime();
        int count = 0;
        int prevEndTime = 0;

        for (Conference conference : conferences) {
            if (prevEndTime <= conference.startTime) {
                prevEndTime = conference.endTime;
                count++;
            }
        }

        return count;
    }

    private static void sortByMeetingStartTime() {
        conferences.sort((conference1, conference2) -> {
            if (conference1.endTime > conference2.endTime) {
                return 1;
            } else if (conference1.endTime < conference2.endTime) {
                return -1;
            } else {
                return conference1.compareTo(conference2);
            }
        });
    }

    private static class Conference {
        private int startTime;
        private int endTime;

        public Conference(final int startTime, final int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int compareTo(final Conference conference) {
            if (startTime > conference.startTime) {
                return 1;
            } else if (startTime < conference.startTime) {
                return -1;
            }

            return 0;
        }

    }
}
