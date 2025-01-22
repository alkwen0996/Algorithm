import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int abc = a * b * c;

        int[] alphabetCount = new int[10];
        char[] charArray = String.valueOf(abc).toCharArray();

        for (char character : charArray) {
            alphabetCount[Integer.parseInt(Character.toString(character))]++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int j : alphabetCount) {
            stringBuilder.append(j).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
