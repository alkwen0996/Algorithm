import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantMap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (participantMap.containsKey(participant[i])) {
                participantMap.put(participant[i], participantMap.get(participant[i]) + 1);
                continue;
            }

            participantMap.put(participant[i], 1);
        }

        for (int i = 0; i < completion.length; i++) {
            participantMap.put(completion[i], participantMap.get(completion[i]) - 1);
        }

        for (Map.Entry<String, Integer> entry : participantMap.entrySet()) {
            int flag = participantMap.get(entry.getKey());

            if (flag == 0) {
                continue;
            }

            answer = entry.getKey();
            break;
        }

        return answer;
    }
}