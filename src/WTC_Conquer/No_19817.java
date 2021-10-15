package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_19817 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Queue<Company> wages = new PriorityQueue<>();

        final int companyNumber = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < companyNumber; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int employees = Integer.parseInt(stringTokenizer.nextToken());
            int companyHighestWage = Integer.parseInt(stringTokenizer.nextToken());

            while (stringTokenizer.hasMoreTokens()) {
                companyHighestWage = Math.max(companyHighestWage, Integer.parseInt(stringTokenizer.nextToken()));
            }

            wages.add(new Company(employees, companyHighestWage));
        }

        Company wage = wages.poll();
        int highestWageInBothCompany = wage.highestWage;

        long sum = 0;
        while (!wages.isEmpty()) {
            wage = wages.poll();
            int wageGapBothCompany = highestWageInBothCompany - wage.highestWage;
            int companyEmployees = wage.employees;

            sum += (long) wageGapBothCompany * companyEmployees;
        }

        System.out.println(sum);
    }

    private static class Company implements Comparable<Company> {
        private final int employees;
        private final int highestWage;

        public Company(final int employees, final int highestWage) {
            this.employees = employees;
            this.highestWage = highestWage;
        }

        @Override
        public int compareTo(final Company company) {
            if (this.highestWage > company.highestWage) {
                return -1;
            } else if (this.highestWage < company.highestWage) {
                return 1;
            }
            return 0;
        }

    }
}
