import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] students = new int[30];

        for (int i = 0; i < 28; i++) {
            students[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 1; i <= 30; i++) {
            boolean check = false;

            for (int j = 0; j < students.length; j++) {
                if (i == students[j]) {
                    check = true;
                }
            }

            if (check) {
                continue;
            }

            System.out.println(i);
        }

    }
}
