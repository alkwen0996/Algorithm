import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> reportInfoMap = new HashMap<>();
        HashMap<String, Integer> reportedIdxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportInfoMap.put(id_list[i], new HashSet<>());
            reportedIdxMap.put(id_list[i], i);
        }

        StringTokenizer stringTokenizer;

        for (int i = 0; i < report.length; i++) {
            stringTokenizer = new StringTokenizer(report[i]);

            String first = stringTokenizer.nextToken();
            String second = stringTokenizer.nextToken();

            reportInfoMap.get(second).add(first);
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            Set<String> sendList = reportInfoMap.get(id_list[i]);

            if (sendList.size() >= k) {
                for (String sendPerson : sendList) {
                    answer[reportedIdxMap.get(sendPerson)]++;
                }
            }
        }

        return answer;
    }
}