package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class No_23056 {
    public static final String EOF = "0 0";
    public static final String DELIMITER_NEWLINE = "\n";
    public static final String DELIMITER_SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Participant> participants = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        String input = "";
        while (!(input = bufferedReader.readLine()).equals(EOF)) {
            stringTokenizer = new StringTokenizer(input);
            participants.add(new Participant(Integer.parseInt(stringTokenizer.nextToken()), 0, stringTokenizer.nextToken()));
        }

        String result = solve(participants, M, N);
        System.out.println(result);
    }

    private static String solve(List<Participant> participants, final int M, final int N) {
        final StringBuilder stringBuilder = new StringBuilder();
        int[] classOrderCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (Participant participant : participants) {
                if (participant.classNo == i) {
                    classOrderCount[participant.classNo]++;
                    participant.classOrder = classOrderCount[participant.classNo];
                }
            }
        }

        participants = participants.stream().filter(t -> t.classOrder <= M).collect(Collectors.toList());

        final List<Participant> blueTeam = new ArrayList<>();
        final List<Participant> whiteTeam = new ArrayList<>();

        for (Participant value : participants) {
            if (value.classNo % 2 == 0) {
                whiteTeam.add(value);
            } else {
                blueTeam.add(value);
            }
        }

        Collections.sort(whiteTeam);
        Collections.sort(blueTeam);

        for (Participant Participant : blueTeam) {
            stringBuilder.append(Participant.classNo).append(DELIMITER_SPACE).append(Participant.name).append(DELIMITER_NEWLINE);
        }

        for (int i = 0; i < whiteTeam.size(); i++) {
            if (i == whiteTeam.size() - 1) {
                stringBuilder.append(whiteTeam.get(i).classNo).append(DELIMITER_SPACE).append(whiteTeam.get(i).name);
            } else {
                stringBuilder.append(whiteTeam.get(i).classNo).append(DELIMITER_SPACE).append(whiteTeam.get(i).name).append(DELIMITER_NEWLINE);
            }
        }

        return stringBuilder.toString();
    }

    private static class Participant implements Comparable<Participant> {
        private final int classNo;
        private int classOrder;
        private final String name;

        public Participant(final int classNo, final int classOrder, final String name) {
            this.classNo = classNo;
            this.classOrder = classOrder;
            this.name = name;
        }

        @Override
        public int compareTo(final Participant participant) {
            if (classNo < participant.classNo) {
                return -1;
            } else if (classNo > participant.classNo) {
                return 1;
            } else {
                if (name.length() < participant.name.length()) {
                    return -1;
                } else if (name.length() > participant.name.length()) {
                    return 1;
                } else {
                    return name.compareTo(participant.name);
                }
            }
        }

    }
}
