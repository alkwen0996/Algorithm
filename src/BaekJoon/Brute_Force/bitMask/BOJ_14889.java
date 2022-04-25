package BaekJoon.Brute_Force.bitMask;

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

        int minimumDifference = findMinimumAbilityDifference(abilityBoard);
        System.out.println(minimumDifference);
    }

    private static int findMinimumAbilityDifference(final int[][] abilityBoard) {
        int minimumDifference = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << (abilityBoard.length)); i++) {
            int count = 0;

            for (int j = 0; j < abilityBoard.length; j++) {
                if ((i & (1 << j)) == 0) {
                    count += 1;
                }
            }

            if (count != abilityBoard.length / 2) {
                continue;
            }

            final List<Integer> startTeam = new ArrayList<>();
            final List<Integer> linkTeam = new ArrayList<>();

            for (int j = 0; j < abilityBoard.length; j++) {
                if ((i & (1 << j)) == 0) {
                    startTeam.add(j);
                    continue;
                }

                linkTeam.add(j);
            }

            int startTeamAbility = 0;
            int linkTeamAbility = 0;

            for (int j = 0; j < abilityBoard.length / 2; j++) {
                for (int k = 0; k < abilityBoard.length / 2; k++) {
                    if (j == k) {
                        continue;
                    }

                    startTeamAbility += abilityBoard[startTeam.get(j)][startTeam.get(k)];
                    linkTeamAbility += abilityBoard[linkTeam.get(j)][linkTeam.get(k)];
                }
            }

            minimumDifference = Math.min(minimumDifference, Math.abs(startTeamAbility - linkTeamAbility));
        }

        return minimumDifference;
    }

}
