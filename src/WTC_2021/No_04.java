package WTC_2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No_04 {
    public static void main(String[] args) {
        String s = "aaabbaaa";
//        String s = "wowwow";
//        String s = "bab";

        int[] answer = solution(s);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    private static int[] solution(final String s) {
        char start = s.charAt(0);
        final List<Integer> result = new LinkedList<>();

        char[] characters = s.toCharArray();
        int index = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (start != characters[i]) {
                index = i;
                break;
            }
        }
        if (index == s.length()) {
            return new int[] {index};
        }
        int count = 1;
        for (int i = 0; i < index + 1; i++) {
            if (index > i && characters[i + 1] == characters[i]) {
                count++;
            } else {
                result.add(count);
                count = 1;
            }
        }
        final Integer val = result.remove(0);
        result.add(0, val + s.length() - index - 1);


        final int[] characterCount = new int[result.size()];

        for (int i =0; i < result.size(); i++){
            characterCount[i] = result.get(i);
        }

        Arrays.sort(characterCount);

        return characterCount;
    }
}
