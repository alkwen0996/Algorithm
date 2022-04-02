package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15661 {
    private static int[][] abilityBoard;
    private static int numberOfPeople;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        numberOfPeople = Integer.parseInt(bufferedReader.readLine());

        abilityBoard = new int[numberOfPeople][numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < numberOfPeople; j++) {
                abilityBoard[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        final List<Integer> startTeam = new ArrayList<>();
        final List<Integer> linkTeam = new ArrayList<>();

        int index = 0;
        System.out.println(findMinimumAbilityGap(index, startTeam, linkTeam));
    }

    private static int findMinimumAbilityGap(final int index, final List<Integer> startTeam, final List<Integer> linkTeam) {
        if (index == numberOfPeople) {
            if (startTeam.size() == 0) {
                return -1;
            }

            if (linkTeam.size() == 0) {
                return -1;
            }

            int startTeamAbility = 0, linkTeamAbility = 0;

            for (int i = 0; i < startTeam.size(); i++) {
                for (int j = 0; j < startTeam.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    startTeamAbility += abilityBoard[startTeam.get(i)][startTeam.get(j)];
                }
            }

            for (int i = 0; i < linkTeam.size(); i++) {
                for (int j = 0; j < linkTeam.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    linkTeamAbility += abilityBoard[linkTeam.get(i)][linkTeam.get(j)];
                }
            }

            return Math.abs(startTeamAbility - linkTeamAbility);
        }

        int minimumAbilityGap = -1;

        startTeam.add(index);
        int startAbility = findMinimumAbilityGap(index + 1, startTeam, linkTeam);

        if (minimumAbilityGap == -1 || (startAbility != -1 && minimumAbilityGap > startAbility)) {
            minimumAbilityGap = startAbility;
        }

        startTeam.remove(startTeam.size() - 1);

        linkTeam.add(index);
        int linkAbility = findMinimumAbilityGap(index + 1, startTeam, linkTeam);

        if (minimumAbilityGap == -1 || (linkAbility != -1 && minimumAbilityGap > linkAbility)) {
            minimumAbilityGap = linkAbility;
        }

        linkTeam.remove(linkTeam.size() - 1);

        return minimumAbilityGap;
    }
}
