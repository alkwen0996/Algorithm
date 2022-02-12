package Programmers.Level2;

import java.util.Arrays;

public class No_42577 {
    public static void main(String[] args) {
        String[] phone_book = {"11", "23", "19", "193"};

        boolean result = solution(phone_book);
        System.out.println(result);
    }

    private static boolean solution(final String[] phone_book) {
        Arrays.sort(phone_book);
        // 문자열은 사전순으로 정렬

        System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < phone_book.length - 1; i++) {
            String prefix = phone_book[i];

            if (prefix.equals(phone_book[i + 1])) {
                return false;
            }

            if (phone_book[i + 1].startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }
}
