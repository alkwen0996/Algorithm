import java.util.Arrays;
class Solution {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] splitArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(splitArray);

            answer[i] = splitArray[commands[i][2] - 1];
        }

        return answer;
    }
}