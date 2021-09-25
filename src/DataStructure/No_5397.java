package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_5397 {

    public static final String DASH = "-";
    public static final String LEFT_INEQUALITY_SIGN = ">";
    public static final String RIGHT_INEQUALITY_SIGN = "<";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append("\n");
        }
    }

    private static String solve(final String readLine) {
        // 백스페이스는 - 기호
        // 커서 바로앞에 글자가 존재하면 해당글자 삭제
        // 화살표는 < or >
        // 커서의 위치를 움직일 수 있다면 왼쪽 또는 오른쪽으로 1만큼 이동.
        // 링크드리스트 & 스택이용

        String result = readLine;
        if (readLine.contains(RIGHT_INEQUALITY_SIGN) || readLine.contains(LEFT_INEQUALITY_SIGN) || readLine.contains(DASH)) {
            result = deleteSign(readLine);
        }

        return result;
    }

    private static String deleteSign(final String readLine) {
        final List<String> resultPW = new LinkedList<>();
        final Deque<String> inputPasswords = new ArrayDeque<>();
        char[] inputDataChars = readLine.toCharArray();

        for (final char inputDataChar : inputDataChars) {
            inputPasswords.push(String.valueOf(inputDataChar));
        }

        for (int i = 0; i < inputPasswords.size(); i++) {
            String word = inputPasswords.pop();
            if(word.equals(DASH)){
                inputPasswords.pop();
            }else if(word.equals(RIGHT_INEQUALITY_SIGN)){

            }else if(word.equals(LEFT_INEQUALITY_SIGN)){

            }else{

            }
        }

        return null;
    }
}
