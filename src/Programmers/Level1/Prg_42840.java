package Programmers.Level1;

import java.util.Arrays;

public class Prg_42840 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};

        int[] result = solution(answers);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(final int[] answers) {
        int[] firstStudent = {1, 2, 3, 4, 5};
        int[] secondStudent = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdStudent = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answerCount = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (firstStudent[i % firstStudent.length] == answers[i]) {
                answerCount[0]++;
            }

            if (secondStudent[i % secondStudent.length] == answers[i]) {
                answerCount[1]++;
            }

            if (thirdStudent[i % thirdStudent.length] == answers[i]) {
                answerCount[2]++;
            }
        }

        int maxAnswerCount = Arrays.stream(answerCount).max().getAsInt();
        int[] result = new int[answerCount.length];

        for (int i = 0; i < answerCount.length; i++) {
            if (maxAnswerCount == answerCount[i]) {
                result[i] = i + 1;
            }
        }

        return Arrays.stream(result).filter(a -> a != 0).toArray();
    }
}
