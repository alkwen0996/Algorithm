package baekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int conferenceCount = Integer.parseInt(bufferedReader.readLine());

        final List<Meeting> conferences = new ArrayList<>();

        for (int i = 0; i < conferenceCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            conferences.add(new Meeting(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        System.out.println(solution(conferences));
    }

    private static int solution(final List<Meeting> conferences) {
        SortMeetingByTime(conferences); // 미팅 시간별로 정렬.
        int possibleMeetingCount = 0;
        int prevMeetingTime = 0;

        for (final Meeting meeting : conferences) {
            if (prevMeetingTime <= meeting.startTime) {
                prevMeetingTime = meeting.endTime;
                possibleMeetingCount++;
            }
        }

        return possibleMeetingCount;
    }

    private static void SortMeetingByTime(final List<Meeting> conferences) {
        conferences.sort((meeting1, meeting2) -> {
            if (meeting1.endTime != meeting2.endTime) {
                return meeting1.endTime - meeting2.endTime;
            }

            return meeting1.compareTo(meeting2); // 0,음수를 반환하면 그대로, 양수를 리턴하면 순서바꿈.
        });

    }

    static class Meeting implements Comparable<Meeting> {
        private int startTime;
        private int endTime;

        public Meeting(final int startTime, final int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(final Meeting meeting) {
            return this.startTime - meeting.startTime;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

    }

}
