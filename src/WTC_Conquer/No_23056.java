package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_23056 {
    public static final String EOF = "0 0";
    public static final String DELIMITER_NEWLINE = "\n";
    public static final String DELIMITER_SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Queue<Participant> participants = new PriorityQueue<>(Comparator.comparingInt(Participant::classifyTeam)
                .thenComparingInt(participant -> participant.classNo)
                .thenComparingInt(Participant::nameLength)
                .thenComparing(participant -> participant.name));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] classOrderCount = new int[N + 1];

        String input = "";
        while (!(input = bufferedReader.readLine()).equals(EOF)) {
            stringTokenizer = new StringTokenizer(input);
            int classNo = Integer.parseInt(stringTokenizer.nextToken());
            String name = stringTokenizer.nextToken();


            if (classOrderCount[classNo] >= M) {
                continue;
            }
            classOrderCount[classNo]++;

            participants.add(new Participant(classNo, name));
        }

        String result = solve(participants, M, N);
        System.out.println(result);
    }

    private static String solve(Queue<Participant> participants, final int M, final int N) {
        final StringBuilder stringBuilder = new StringBuilder();

        while (!participants.isEmpty()) {
            Participant participant = participants.poll();
            stringBuilder.append(participant.classNo).append(DELIMITER_SPACE).append(participant.name).append(DELIMITER_NEWLINE);
        }

        return stringBuilder.toString();
    }

    private static class Participant {
        private final int classNo;
        private final String name;

        public Participant(final int classNo, final String name) {
            this.classNo = classNo;
            this.name = name;
        }

        public int classifyTeam() {
            return -this.classNo % 2;
        }

        public int nameLength() {
            return this.name.length();
        }
    }
}
