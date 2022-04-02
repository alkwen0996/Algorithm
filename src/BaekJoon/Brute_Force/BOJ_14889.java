package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889 {
    private static int numberOfPeople;
    private static int[][] abilityBoard;

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

        int index = 0;
        List<Integer> teamStart = new ArrayList<>();
        List<Integer> teamLink = new ArrayList<>();

        System.out.println(teamBuilding(index, teamStart, teamLink));
    }

    private static int teamBuilding(int index, List<Integer> teamStart, List<Integer> teamLink) {
        if (index == numberOfPeople) {
            if (teamStart.size() != numberOfPeople / 2) {
                return -1;
            }

            if (teamLink.size() != numberOfPeople / 2) {
                return -1;
            }

            int startTeamAbility = 0;
            int linkTeamAbility = 0;

            for (int i = 0; i < numberOfPeople / 2; i++) {
                for (int j = 0; j < numberOfPeople / 2; j++) {
                    if (i == j) {
                        continue;
                    }

                    startTeamAbility += abilityBoard[teamStart.get(i)][teamStart.get(j)];
                    linkTeamAbility += abilityBoard[teamLink.get(i)][teamLink.get(j)];
                }
            }

            return Math.abs(startTeamAbility - linkTeamAbility);
        }

        if (teamStart.size() > numberOfPeople / 2 || teamLink.size() > numberOfPeople) {
            return -1;
        }

        int answer = -1;
        teamStart.add(index);
        int startTeamAbility = teamBuilding(index + 1, teamStart, teamLink);

        if (answer == -1 || startTeamAbility != -1 && answer > startTeamAbility) {
            answer = startTeamAbility;
        }
        teamStart.remove(teamStart.size() - 1);

        teamLink.add(index);
        int linkTeamAbility = teamBuilding(index + 1, teamStart, teamLink);

        if (answer == -1 || (linkTeamAbility != -1 && answer > linkTeamAbility)) {
            answer = linkTeamAbility;
        }
        teamLink.remove(teamLink.size() - 1);

        return answer;
    }

}
