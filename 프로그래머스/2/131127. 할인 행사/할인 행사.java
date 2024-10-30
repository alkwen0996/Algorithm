import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        HashMap<String, Integer> compareMap = new HashMap<>();

        for (int i = 0; i < discount.length; i++) {
            if (i >= 10) {
                if (compareMap.get(discount[i - 10]) > 0) {
                    compareMap.put(discount[i - 10], compareMap.get(discount[i - 10]) - 1);
                } else if (compareMap.get(discount[i - 10]) == 0) {
                    compareMap.remove(discount[i - 10]);
                }
            }

            if (compareMap.containsKey(discount[i])) {
                compareMap.put(discount[i], compareMap.get(discount[i]) + 1);
            } else {
                compareMap.put(discount[i], 1);
            }

            if (checkShopping(map, compareMap)) {
                answer++;
            }
        }

        return answer;
    }
    
    public boolean checkShopping(final HashMap<String, Integer> map, final HashMap<String, Integer> compareMap) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()).equals(compareMap.get(entry.getKey()))) {
                continue;
            }

            return false;
        }

        return true;
    }
}