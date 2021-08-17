package Loop_While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class No_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringbuilder = new StringBuilder();
        String input = "";

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        input = stringTokenizer.nextToken();
        String originalInput = input;
        int count = 0;

        if(originalInput.length() == 1){
            originalInput = "0"+originalInput;
        }

        while (!stringbuilder.toString().equals(originalInput.toString())) {

            if (stringbuilder.toString().length() != 0) {
                input = stringbuilder.toString();
                stringbuilder.delete(0, stringbuilder.length());
            }

            if (input.length() == 1) {
                stringbuilder.append("0").append(input);
            }

            if (input.length() == 2) {
                stringbuilder.append(input);
            }

            String tensDigit = stringbuilder.substring(0, 1);
            String unitDigit = stringbuilder.substring(1, 2);
            stringbuilder.delete(0, stringbuilder.length());

            int sum = Integer.parseInt(tensDigit) + Integer.parseInt(unitDigit);

            stringbuilder.append(unitDigit).append(sum);

            if (stringbuilder.toString().length() == 3) {
                stringbuilder.delete(1, 2);
            }

            count++;
        }
        System.out.println(count);

    }
}
