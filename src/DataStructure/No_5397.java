package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class No_5397 {
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
        final Deque<String> password = new ArrayDeque<>();
        char[] inputData = readLine.toCharArray();

        for (int i = 0; i < inputData.length; i++) {

        }

        return "";
    }
}
