package BaekJoon.Brute_Force.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int numberOfPeople = Integer.parseInt(bufferedReader.readLine());
        final int[][] abilityBoard = new int[numberOfPeople][numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < numberOfPeople; j++) {
                abilityBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int result = solution(abilityBoard, numberOfPeople);
        System.out.println(result);
    }

    private static int solution(final int[][] abilityBoard, final int numberOfPeople) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < (1 << numberOfPeople); i++) {
            int count = 0;

            for (int j = 0; j < numberOfPeople; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                }
            }

            if (count != numberOfPeople / 2) {
                continue;
            }

            final List<Integer> startTeam = new ArrayList<>();
            final List<Integer> linkTeam = new ArrayList<>();

            for (int j = 0; j < numberOfPeople; j++) {
                if ((i & (1 << j)) == 0) {
                    startTeam.add(j);
                } else {
                    linkTeam.add(j);
                }
            }

            int startTeamAbility = 0;
            int linkTeamAbility = 0;

            for (int j = 0; j < numberOfPeople / 2; j++) {
                for (int k = 0; k < numberOfPeople / 2; k++) {
                    if (j == k) {
                        continue;
                    }

                    startTeamAbility += abilityBoard[startTeam.get(j)][startTeam.get(k)];
                    linkTeamAbility += abilityBoard[linkTeam.get(j)][linkTeam.get(k)];
                }
            }

            int difference = Math.abs(startTeamAbility - linkTeamAbility);
            answer = Math.min(answer, difference);
        }

        return answer;
    }

}
