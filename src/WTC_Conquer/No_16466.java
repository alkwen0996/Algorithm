package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_16466 {
    private static final int START_TICKET_NUMBER = 1;
    private static final int TICKET_NUMBER_RANGE = 1_000_001;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final Queue<Integer> soldTicketNumbers = new PriorityQueue<>();

        while (stringTokenizer.hasMoreTokens()) {
            soldTicketNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solve(soldTicketNumbers);
        System.out.println(result);
    }

    private static int solve(final Queue<Integer> soldTicketNumbers) {
        int smallestTicketNumber = START_TICKET_NUMBER;

        boolean[] checkSoldNumber = new boolean[TICKET_NUMBER_RANGE];

        while (!soldTicketNumbers.isEmpty()) {
            int ticketNumber = soldTicketNumbers.poll();
            checkSoldNumber[ticketNumber - 1] = true;
        }

        for (int i = 0; i < checkSoldNumber.length; i++) {
            if (!checkSoldNumber[i]) {
                smallestTicketNumber = i + 1;
                break;
            }
        }

        return smallestTicketNumber;
    }
}
