package Implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No_8958 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt();



        List<String> OXStringList = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            String OXString = scanner.next();
            OXStringList.add(OXString);
        }

        for (int i = 0; i < rowCount; i++) {
            int score = giveScore(OXStringList.get(i));
            System.out.println(score);
        }
    }

    private static int giveScore(String OXString) {
        char[] OXStringArray = OXString.toCharArray();
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < OXStringArray.length; i++) {
            if (OXStringArray[i] == 'X') {
                cnt = 0;
            }
            if (OXStringArray[i] == 'O') {
                cnt += 1;
            }
            sum += cnt;
        }
        return sum;
    }
}
