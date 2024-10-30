import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();

        StringTokenizer stringTokenizer;

        for (int i = 0; i < record.length; i++) {
            stringTokenizer = new StringTokenizer(record[i]);

            String status = stringTokenizer.nextToken();
            String userId = stringTokenizer.nextToken();
            String userName;

            if (status.equals("Enter") || status.equals("Change")) {
                userName = stringTokenizer.nextToken();
                user.put(userId, userName);
            }
        }

        ArrayList<String> messageList = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            stringTokenizer = new StringTokenizer(record[i]);

            String status = stringTokenizer.nextToken();
            String userId = stringTokenizer.nextToken();

            if (status.equals("Enter")) {
                messageList.add(user.get(userId) + "님이 들어왔습니다.");
            } else if (status.equals("Leave")) {
                messageList.add(user.get(userId) + "님이 나갔습니다.");
            }
        }

        return messageList.toArray(new String[messageList.size()]);
    }
}