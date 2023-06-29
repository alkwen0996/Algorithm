import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // 재귀로 풀면 시간제한 걸려서 터질거같음...
    // 부분집합 시간복잡도 2^N... -> N이 10만...
    // 배열이 4개로 고정되어있다.
    // 슬라이딩 윈도우로 풀면 될듯하네!

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int S = Integer.parseInt(stringTokenizer.nextToken());
        final int P = Integer.parseInt(stringTokenizer.nextToken());
        final char[] DNA = bufferedReader.readLine().toCharArray();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final Map<Character, Integer> passwordRule = new HashMap<>();

        passwordRule.put('A', Integer.parseInt(stringTokenizer.nextToken()));
        passwordRule.put('C', Integer.parseInt(stringTokenizer.nextToken()));
        passwordRule.put('G', Integer.parseInt(stringTokenizer.nextToken()));
        passwordRule.put('T', Integer.parseInt(stringTokenizer.nextToken()));

        slidingWindow(S, P, DNA, passwordRule);
    }

    private static void slidingWindow(final int s, final int p, final char[] dna, final Map<Character, Integer> passwordRule) {
        final Map<Character, Integer> newPassword = new HashMap<>();

        for (int i = 0; i < p; i++) {
            newPassword.put(dna[i], newPassword.getOrDefault(dna[i], 0) + 1);
        }

        int answer = 0;

        if (checkCount(passwordRule, newPassword)) {
            answer++;
        }

        int point;
        for (int i = p; i < s; i++) {
            point = i - p;
            newPassword.put(dna[i], newPassword.getOrDefault(dna[i], 0) + 1);
            newPassword.put(dna[point], newPassword.get(dna[point]) - 1);

            if (checkCount(passwordRule, newPassword)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean checkCount(final Map<Character, Integer> passwordRule, final Map<Character, Integer> newPassword) {
        for (char character : passwordRule.keySet()) {
            if (passwordRule.get(character) > newPassword.getOrDefault(character, 0)) {
                return false;
            }
        }

        return true;
    }

}
