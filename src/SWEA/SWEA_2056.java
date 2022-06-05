package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2056 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String SIGNAL = "#";
    private static final String SEPARATOR = "/";
    private static final String NOT_VALIDATE = "-1";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final String testCase = bufferedReader.readLine();

            stringBuilder.append(SIGNAL)
                    .append(i + 1)
                    .append(SPACE)
                    .append(checkDate(testCase))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static String checkDate(final String testCase) {
        final String year = testCase.substring(0, 4);
        final String month = testCase.substring(4, 6);
        final String date = testCase.substring(6, 8);

        final int yearToNumber = Integer.parseInt(year);
        final int monthToNumber = Integer.parseInt(month);
        final int dateToNumber = Integer.parseInt(date);

        if (yearToNumber < 0 || monthToNumber <= 0 || monthToNumber > 12 || dateToNumber <= 0) {
            return NOT_VALIDATE;
        }

        if (monthToNumber == 1 || monthToNumber == 3 || monthToNumber == 5 || monthToNumber == 7 ||
                monthToNumber == 8 || monthToNumber == 10 || monthToNumber == 12) {
            if (dateToNumber > 31) {
                return NOT_VALIDATE;
            }
        }

        if (monthToNumber == 9 || monthToNumber == 10 || monthToNumber == 4 || monthToNumber == 6) {
            if (dateToNumber > 30) {
                return NOT_VALIDATE;
            }
        }

        if (monthToNumber == 2) {
            if (dateToNumber > 28) {
                return NOT_VALIDATE;
            }
        }

        return year + SEPARATOR + month + SEPARATOR + date;
    }
}
