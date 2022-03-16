package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_23246 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        final List<Athlete> rankingScore = new ArrayList<>();

        while (n-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int backNumber = Integer.parseInt(stringTokenizer.nextToken());
            int leadScore = Integer.parseInt(stringTokenizer.nextToken());
            int speedScore = Integer.parseInt(stringTokenizer.nextToken());
            int borderingScore = Integer.parseInt(stringTokenizer.nextToken());

            rankingScore.add(new Athlete(backNumber, leadScore, speedScore, borderingScore));
        }

        System.out.println(solve(rankingScore));
    }

    private static StringBuilder solve(final List<Athlete> rankingScore) {
        final StringBuilder stringBuilder = new StringBuilder();

        rankingScore.sort((athlete1, athlete2) -> {
            int compare = 0;
            int athlete1MultipliedScore = athlete1.speedScore * athlete1.leadScore * athlete1.borderingScore;
            int athlete2MultipliedScore = athlete2.speedScore * athlete2.leadScore * athlete2.borderingScore;

            int athlete1SumScore = athlete1.speedScore + athlete1.leadScore + athlete1.borderingScore;
            int athlete2SumScore = athlete2.speedScore + athlete2.leadScore + athlete2.borderingScore;

            if (athlete1MultipliedScore < athlete2MultipliedScore) {
                compare = -1;
            } else if (athlete1MultipliedScore > athlete2MultipliedScore) {
                compare = 1;
            } else {
                if (athlete1SumScore < athlete2SumScore) {
                    compare = -1;
                } else if (athlete1SumScore > athlete2SumScore) {
                    compare = 1;
                } else {
                    if (athlete1.backNumber < athlete2.backNumber) {
                        compare = -1;
                    } else if (athlete1.backNumber > athlete2.backNumber) {
                        compare = 1;
                    }
                }
            }

            return compare;
        });

        for (int i = 0; i < 3; i++) {
            stringBuilder.append(rankingScore.get(i).backNumber).append(" ");
        }

        return stringBuilder;
    }

    private static class Athlete {
        private int backNumber;
        private int leadScore;
        private int speedScore;
        private int borderingScore;

        public Athlete(final int backNumber, final int leadScore, final int speedScore, final int borderingScore) {
            this.backNumber = backNumber;
            this.leadScore = leadScore;
            this.speedScore = speedScore;
            this.borderingScore = borderingScore;
        }

    }
}
