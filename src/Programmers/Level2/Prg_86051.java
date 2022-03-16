package Programmers.Level2;


public class Prg_86051 {
    public static void main(String[] args) {
        int[] numbers = {5, 8, 4, 0, 6, 7, 9};
        int result = solve(numbers);
        System.out.println(result);
    }

    private static int solve(final int[] numbers) {
        int answer = 0;

        for (int i = 0; i <= 9; i++) {
            boolean isContain = true;

            for (final int number : numbers) {
                if (i == number) {
                    isContain = false;
                    break;
                }
            }

            if (isContain) {
                answer += i;
            }
        }

        return answer;
    }

}
