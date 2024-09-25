import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        // 200000 * 500

        int[] challengers = new int[N + 2];

        for (int i = 0; i < stages.length; i++) {
            challengers[stages[i]] += 1;
        }

        Map<Integer, Double> map = new HashMap<>();
        double total = Arrays.stream(challengers).sum();

        for (int i = 1; i <= N; i++) {
            if (challengers[i] == 0) {
                map.put(i, 0.0);
                continue;
            }

            map.put(i, challengers[i] / total);
            total -= challengers[i];
        }

        return map.entrySet().stream().sorted(((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))).mapToInt(Map.Entry::getKey).toArray();
    }
}