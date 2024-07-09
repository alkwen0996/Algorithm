import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String NEW_LINE = "\n";
    public static final String DEPTH = "____";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append(NEW_LINE);
        chatbot(n, 0, stringBuilder);

        System.out.println(stringBuilder);
    } // main

    private static void chatbot(final int n, final int index, final StringBuilder stringBuilder) {
        if (index == n) {
            StringBuilder depth = getDepth(index);
            stringBuilder
                    .append(depth).append("\"재귀함수가 뭔가요?\"").append(NEW_LINE)
                    .append(depth).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append(NEW_LINE)
                    .append(depth).append("라고 답변하였지.").append(NEW_LINE);

            return;
        }
        
        StringBuilder depth = getDepth(index);
        stringBuilder
                .append(depth).append("\"재귀함수가 뭔가요?\"").append(NEW_LINE)
                .append(depth).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append(NEW_LINE)
                .append(depth).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append(NEW_LINE)
                .append(depth).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append(NEW_LINE);
        chatbot(n, index + 1, stringBuilder);
        stringBuilder.append(depth).append("라고 답변하였지.").append(NEW_LINE);
    }

    private static StringBuilder getDepth(final int index) {
        StringBuilder depth = new StringBuilder();

        for (int i = 0; i < index; i++) {
            depth.append(DEPTH);
        }
        return depth;
    }
} // class
