package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_4796 {
    public static final String EOF = "0 0 0";
    public static final String BLANK = "";
    public static final String NEW_LINE = "\n";
    public static final String CASE = "Case ";
    public static final String COLON = ": ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Vacation> vacationInputData = new ArrayList<>();

        String testCase = BLANK;
        while (!(testCase = bufferedReader.readLine()).equals(EOF)) {
            final StringTokenizer stringTokenizer = new StringTokenizer(testCase);
            vacationInputData.add(new Vacation(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        String result = solution(vacationInputData);
        System.out.println(result);
    }

    private static String solution(final List<Vacation> vacationInputData) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < vacationInputData.size(); i++) {
            stringBuilder.append(CASE).append(i + 1).append(COLON).append(countUsingCampSitePeriod(vacationInputData.get(i))).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static int countUsingCampSitePeriod(final Vacation vacation) {
        int vacationPeriod = vacation.vacationPeriod;
        int consecutivePeriod = vacation.consecutivePeriod;
        int availableCampsitePeriod = vacation.availableCampSitePeriod;

        int count = (vacationPeriod / consecutivePeriod) * availableCampsitePeriod;
        count += Math.min(vacationPeriod % consecutivePeriod, availableCampsitePeriod);


        return count;
    }

    private static class Vacation {
        private int availableCampSitePeriod;
        private int consecutivePeriod;
        private int vacationPeriod;

        public Vacation(final int availableCampSitePeriod, final int consecutivePeriod, final int vacationPeriod) {
            this.availableCampSitePeriod = availableCampSitePeriod;
            this.consecutivePeriod = consecutivePeriod;
            this.vacationPeriod = vacationPeriod;
        }
    }

}
