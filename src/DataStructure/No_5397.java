package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_5397 {
    public static final String DASH = "-";
    public static final String LEFT_INEQUALITY_SIGN = "<";
    public static final String RIGHT_INEQUALITY_SIGN = ">";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static String solve(final String readLine) {
        String result = readLine;
        if (readLine.contains(RIGHT_INEQUALITY_SIGN) || readLine.contains(LEFT_INEQUALITY_SIGN) || readLine.contains(DASH)) {
            result = deleteSign(readLine);
        }

        return result;
    }

    private static String deleteSign(final String readLine) {
        char[] inputDataCharters = readLine.toCharArray();
        final Deque<String> inputPassword = new ArrayDeque<>();
        final List<String> resultPassword = new LinkedList<>();

        for (char inputDataCharter : inputDataCharters) {
            inputPassword.addLast(String.valueOf(inputDataCharter));
        }

//        <<BP<A>>Cd-
        // List는 반복문에서 요소를 삭제하면 전체 리스트 길이가 변하므로 사용하기 애매.
        // > 왼쪽, 오른쪽 요소 교환 및 화살표 삭제
        // < 오른쪽, 왼쪽 요소 교환 및 화살표 삭제
        // - 하나 앞의 요소 삭제
        System.out.println(inputPassword.toString());
        final int passwordLength = inputPassword.size();
        for (int i = 0; i < passwordLength; i++) {
            String passwordCharacter = inputPassword.pop();
            System.out.println("추출: "+passwordCharacter);
            System.out.println("추출2: "+inputPassword.pollLast());

            if(passwordCharacter.equals(DASH)){
                System.out.println(inputPassword.removeLast());
            }else if(passwordCharacter.equals(LEFT_INEQUALITY_SIGN)){
                System.out.println("in left in");
                System.out.println(inputPassword.pop());
            }else if(passwordCharacter.equals(RIGHT_INEQUALITY_SIGN)){

            }else{
                inputPassword.addLast(passwordCharacter);
            }
            System.out.println(inputPassword.toString());
        }
        System.out.println(inputPassword.toString());
        return null;
    }
}
