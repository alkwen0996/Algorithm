package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 전반적으로 문제 이해를 잘못하고 품.
//
public class No_5397 {
    public static final String DASH = "-";
    public static final String LEFT_INEQUALITY_SIGN = "<";
    public static final String RIGHT_INEQUALITY_SIGN = ">";
    public static final int ZERO = 0;

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
        } // 화살표나 "-" 기호를 입력문자열이 포함하고 있으면 Password 구하는 함수(deleteSign)로 이동

        return result;
    }

    private static String deleteSign(final String readLine) {
        char[] inputDataCharters = readLine.toCharArray();
        final Deque<String> inputPassword = new ArrayDeque<>();
        final StringBuilder stringBuilder = new StringBuilder();

//        final ArrayList<Object> objects = new ArrayList<>();
//        for (char inputDataCharter : inputDataCharters) {
//            objects.add(inputDataCharter);
//        }
//        System.out.println(objects.toString());
//        System.out.println("-------------------------------");


        boolean leftChangeLocationFlag = true; // 왼쪽으로 커서 이동 플래그
        for (char inputDataCharter : inputDataCharters) {
            String checkCharacter = String.valueOf(inputDataCharter);
            if (checkCharacter.equals(DASH)) { // "-" 포함할 시
                if(inputPassword.size()> ZERO){
                    inputPassword.removeLast(); // 데큐에 데이터가 있으면 - 앞 문자 삭제
                }
            } else if (checkCharacter.equals(LEFT_INEQUALITY_SIGN)) {
                if (inputPassword.size() > ZERO) {
                    leftChangeLocationFlag = false;
                }
            } else if (checkCharacter.equals(RIGHT_INEQUALITY_SIGN)) {

            } else {
                if(!leftChangeLocationFlag){
                    String frontCharacter = inputPassword.pop();
                    inputPassword.push(checkCharacter);
                    inputPassword.push(frontCharacter);
                    leftChangeLocationFlag = true; // 왼쪽화살표가 있을 때 앞문자와 순서 바꿈
                }else{
                    inputPassword.addLast(checkCharacter); // 입력문자가 화살표와 "-"가 아닌 문자일경우 데큐에 문자 추가.
                }
            }
        }

        for (String password:inputPassword) {
            stringBuilder.append(password);
        }
// <<BP<A>>Cd-

        return stringBuilder.toString();
    }
}