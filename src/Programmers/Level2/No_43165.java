package Programmers.Level2;

public class No_43165 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int result = solution(numbers, target);
        System.out.println(result);
    }

    private static int solution(final int[] numbers, final int target) {
        int answer = 0;
        answer += dfs(numbers, target, 0, 0);

        return answer;
    }

    private static int dfs(final int[] numbers, final int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                return 1;
            }

            return 0;
        }


        return dfs(numbers, target, depth + 1, sum + numbers[depth]) + dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
