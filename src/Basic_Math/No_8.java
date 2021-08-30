package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_8 {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final List<String> inputNumbers = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            inputNumbers.add(stringTokenizer.nextToken());
        }

        int result = solve(inputNumbers);
        System.out.println(result);
    }

    private static int solve(final List<String> inputNumbers) {
        int fixedCost = Integer.parseInt(inputNumbers.get(ZERO));
        int variableCost = Integer.parseInt(inputNumbers.get(ONE));
        int notebookCost = Integer.parseInt(inputNumbers.get(TWO));

        if(variableCost > notebookCost){
            return -1;
        }

        int count = 1;
        while(true){
            if(fixedCost+(variableCost*count) < notebookCost*count){
                break;
            }
            count++;
        }
        return count;
    }
}
