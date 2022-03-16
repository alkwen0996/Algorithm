package Programmers.Level1;

import java.util.Arrays;

public class Prg_42576 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String result = solve(participant, completion);
        System.out.println(result);
    }

    private static String solve(final String[] participant, final String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }
}
