import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = bufferedReader.readLine().toCharArray();
        int[] alphabet = new int[10];

        for (char c : charArray) {
            String number = Character.toString(c);

            if (number.equals("6") || number.equals("9")) {
                if (alphabet[6] > alphabet[9]) {
                    number = "9";
                } else if (alphabet[6] < alphabet[9]) {
                    number = "6";
                }
            }

            alphabet[Integer.parseInt(number)]++;
        }

        System.out.println(Arrays.stream(alphabet).max().getAsInt());
    }
}
