import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalAmount = Integer.parseInt(bufferedReader.readLine());
        int numberOfItem = Integer.parseInt(bufferedReader.readLine());

        int result = 0;

        for (int i = 0; i < numberOfItem; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int money = Integer.parseInt(stringTokenizer.nextToken());
            int count = Integer.parseInt(stringTokenizer.nextToken());

            result = result + (money * count);
        }

        if (result == totalAmount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
