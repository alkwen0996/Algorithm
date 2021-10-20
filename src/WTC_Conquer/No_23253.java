package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_23253 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        boolean checkOrder = true;
        String result = "Yes";
        for (int i = 0; i < (2 * M); i++) {
            final Deque<Integer> books = new ArrayDeque<>();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            if (stringTokenizer.countTokens() == 1) {
                continue;
            }

            while (stringTokenizer.hasMoreTokens()) {
                books.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            checkOrder = booksOrderCheck(books);
            if (!checkOrder) {
                result = "No";
            }
        }

        System.out.println(result);

    }

    private static boolean booksOrderCheck(final Deque<Integer> books) {

        int bookNumber = books.pop();
        while (!books.isEmpty()) {
            int nextBooksNumber = books.pop();

            if (bookNumber < nextBooksNumber) {
                return false;
            }

            bookNumber = nextBooksNumber;
        }

        return true;
    }
}
