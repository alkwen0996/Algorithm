package BaekJoon.Brute_Force.recursiveFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889 {
    private static int[][] abilityBoard;
    private static int minimumDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfPeople = Integer.parseInt(bufferedReader.readLine());

        abilityBoard = new int[numberOfPeople][numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < numberOfPeople; j++) {
                abilityBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int index = 0;
        final List<Integer> startTeam = new ArrayList<>();
        final List<Integer> linkTeam = new ArrayList<>();

        findMinimumAbilityDifference(startTeam, linkTeam, index);
        System.out.println(minimumDifference);
    }

    private static void findMinimumAbilityDifference(final List<Integer> startTeam, final List<Integer> linkTeam, final int index) {
        if (index == abilityBoard.length) {
            if (startTeam.size() != abilityBoard.length / 2 || linkTeam.size() != abilityBoard.length / 2) {
                return;
            }

            int startTeamAbility = 0;
            int linkTeamAbility = 0;

            for (int i = 0; i < abilityBoard.length / 2; i++) {
                for (int j = 0; j < abilityBoard.length / 2; j++) {
                    if (i == j) {
                        continue;
                    }

                    startTeamAbility += abilityBoard[startTeam.get(i)][startTeam.get(j)];
                    linkTeamAbility += abilityBoard[linkTeam.get(i)][linkTeam.get(j)];
                }
            }

            minimumDifference = Math.min(minimumDifference, Math.abs(startTeamAbility - linkTeamAbility));
            return;
        }

        if (startTeam.size() > abilityBoard.length / 2 || linkTeam.size() > abilityBoard.length / 2) {
            return;
        }

        startTeam.add(index);
        findMinimumAbilityDifference(startTeam, linkTeam, index + 1);
        startTeam.remove(startTeam.size() - 1);

        linkTeam.add(index);
        findMinimumAbilityDifference(startTeam, linkTeam, index+1);
        linkTeam.remove(linkTeam.size() - 1);

    }

}
