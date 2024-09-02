import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] studentScores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) {
                studentScores[0]++;
            }

            if (answers[i] == second[i % second.length]) {
                studentScores[1]++;
            }

            if (answers[i] == third[i % third.length]) {
                studentScores[2]++;
            }
        }

        int maxScore = Arrays.stream(studentScores).max().getAsInt();
        List<Integer> maxScoreStudents = new ArrayList<>();

        for (int i = 0; i < studentScores.length; i++) {
            if (maxScore == studentScores[i]) {
                maxScoreStudents.add(i + 1);
            }
        }

        return maxScoreStudents.stream().mapToInt(i -> i).toArray();
    }
}