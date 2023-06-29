import java.util.Scanner;

public class Main {
    public static final String NEW_LINE = "\n";
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        stringBuilder.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append(NEW_LINE);

        recursive(N, 0);
        System.out.println(stringBuilder);
    }

    private static void recursive(final int n, final int step) {
        if (step == n) {
            printMessage(step, "\"재귀함수가 뭔가요?\"");
            printMessage(step, "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            printMessage(step, "라고 답변하였지.");

            return;
        }

        printMessage(step, "\"재귀함수가 뭔가요?\"");
        printMessage(step, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        printMessage(step, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        printMessage(step, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        recursive(n, step + 1);
        printMessage(step, "라고 답변하였지.");
    }

    private static void printMessage(final int step, final String str) {
        stringBuilder.append("____".repeat(Math.max(0, step)));
        stringBuilder.append(str).append(NEW_LINE);
    }

}
