import java.util.*;

class Solution {
    public static int[] solution(final String[] gems) {
        Set<String> gemsType = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> buyGems = new HashMap<>();
        int[] answer = new int[2];

        int start = 0;
        int length = 1_000_000;

        for (int i = 0; i < gems.length; i++) {
            buyGems.put(gems[i], buyGems.getOrDefault(gems[i], 0) + 1);

            while (buyGems.get(gems[start]) > 1) {
                buyGems.put(gems[start], buyGems.get(gems[start]) - 1);
                start++;
            }

            if (buyGems.size() == gemsType.size() && length > (i - start)) {
                length = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }

        return answer;
    }
}