import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int max = 0;
        int row = 1;
        int column = 1;

        for (int i = 1; i <= 9; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 1; j <= 9; j++) {
                int number = Integer.parseInt(stringTokenizer.nextToken());

                if (max < number) {
                    max = number;
                    row = i;
                    column = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + column);
    }
} // class
