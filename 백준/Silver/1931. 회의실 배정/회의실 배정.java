import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Queue<Meeting> meetings = new PriorityQueue<>();
        StringTokenizer stringTokenizer;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            meetings.add(new Meeting(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        System.out.println(selectMeeting(meetings));
    }

    private static int selectMeeting(final Queue<Meeting> meetings) {
        Meeting meeting = meetings.poll();
        int count = 1;

        while (!meetings.isEmpty()) {
            Meeting peek = meetings.peek();

            if (meeting.endTime > peek.startTime) {
                meetings.poll();
            } else {
                meeting = meetings.poll();
                count++;
            }
        }

        return count;
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
            if (this.endTime < meeting.endTime) {
                return -1;
            } else if (this.endTime > meeting.endTime) {
                return 1;
            } else {
                return Integer.compare(this.startTime, meeting.startTime);
            }

        }

    }

}