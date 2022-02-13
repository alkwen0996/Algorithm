package Programmers.Level1;

public class Prg_12903 {
    public static void main(String[] args) {
//        String s = "abcde";
        String s = "qwer";

        String result = solution(s);
        System.out.println(result);
    }

    private static String solution(final String s) {
        int beginIndex = (s.length() - 1) / 2;
        int endIndex = s.length() / 2 + 1;

        return s.substring(beginIndex, endIndex);
    }
}
