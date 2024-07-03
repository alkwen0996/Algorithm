import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[7];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int sum = Arrays.stream(numbers).filter(a -> a % 2 == 1).sum();

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum + "\n" + Arrays.stream(numbers).filter(a -> a % 2 == 1).min().getAsInt());
        }
    }
} // class
