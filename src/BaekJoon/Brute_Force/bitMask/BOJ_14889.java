package BaekJoon.Brute_Force.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889 {
    private static int[][] abilityBoard;
    private static boolean[] visited;

    private static int minimumDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfPeople = Integer.parseInt(bufferedReader.readLine());

        abilityBoard = new int[numberOfPeople][numberOfPeople];
        visited = new boolean[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < numberOfPeople; j++) {
                abilityBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int index = 0;
        final List<Integer> startTeam = new ArrayList<>();
        final List<Integer> linkTeam = new ArrayList<>();

        findMinimumAbilityDifference(index);
        System.out.println(minimumDifference);
    }

    private static void findMinimumAbilityDifference(final int index) {
        if (index == abilityBoard.length) {
            int startTeamAbility = 0;
            int linkTeamAbility = 0;

            for (int i = 0; i < abilityBoard.length - 1; i++) {
                for (int j = i + 1; j < abilityBoard.length; j++) {
                    if (visited[i] && visited[j]) {
                        startTeamAbility += abilityBoard[i][j];
                        startTeamAbility += abilityBoard[j][i];
                    }

                    if (!visited[i] && !visited[j]) {
                        linkTeamAbility += abilityBoard[i][j];
                        linkTeamAbility += abilityBoard[j][i];
                    }

                }
            }

            minimumDifference = Math.min(minimumDifference, Math.abs(startTeamAbility - linkTeamAbility));
            return;
        }

        for (int i = index; i < abilityBoard.length; i++) {
            visited[i] = true;
            findMinimumAbilityDifference(index + 1);
            visited[i] = false;
        }

    }

}
