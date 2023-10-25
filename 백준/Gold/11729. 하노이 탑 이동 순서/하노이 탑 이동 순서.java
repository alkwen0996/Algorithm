import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int from = 1;
        int mid = 2;
        int to = 3;

        StringBuilder stringBuilder = new StringBuilder();

        int count = (int) (Math.pow(2, n) - 1);
        stringBuilder.append(count).append(NEW_LINE);

        Hanoi(n, from, mid, to, stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void Hanoi(final int n, final int from, final int mid, final int to, final StringBuilder stringBuilder) {
        // 원판 n개를 a 기둥에서 b 기둥으로 옮기는 함수
        if (n == 1) {
            stringBuilder.append(from).append(SPACE).append(to).append(NEW_LINE);
            return;
        }

        Hanoi(n - 1, from, to, mid, stringBuilder); // 1 -> 2
        stringBuilder.append(from).append(SPACE).append(to).append(NEW_LINE); // 1 -> 3
        Hanoi(n - 1, mid, from, to, stringBuilder); // 2 -> 3
    }

}
