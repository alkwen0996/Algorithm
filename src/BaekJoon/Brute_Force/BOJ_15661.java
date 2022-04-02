package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661 {
    private static int[][] abilityBoard;
    private static int numberOfPeople;
    private static boolean[] visited;
    private static int minimumAbilityGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        numberOfPeople = Integer.parseInt(bufferedReader.readLine());

        abilityBoard = new int[numberOfPeople][numberOfPeople];
        visited = new boolean[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < numberOfPeople; j++) {
                abilityBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int index = 0;
        findMinimumAbilityGap(index);

        System.out.println(minimumAbilityGap);
    }

    private static void findMinimumAbilityGap(final int index) {
        if (index == numberOfPeople) {
            int startTeamAbility = 0, linkTeamAbility = 0;

            for (int i = 0; i < numberOfPeople; i++) {
                for (int j = i + 1; j < numberOfPeople; j++) {
                    if (visited[i] != visited[j]) {
                        continue;
                    }

                    if (visited[i]) {
                        startTeamAbility += abilityBoard[i][j] + abilityBoard[j][i];
                    } else {
                        linkTeamAbility += abilityBoard[i][j] + abilityBoard[j][i];
                    }
                }
            }

            minimumAbilityGap = Math.min(minimumAbilityGap, Math.abs(startTeamAbility - linkTeamAbility));

            return;
        }

        visited[index] = true;
        findMinimumAbilityGap(index + 1);
        visited[index] = false;
        findMinimumAbilityGap(index + 1);
    }
}
