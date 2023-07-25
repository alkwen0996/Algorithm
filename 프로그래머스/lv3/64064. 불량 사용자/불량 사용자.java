import java.util.HashSet;
import java.util.Set;

class Solution {
    
    Set<Set<String>> bandIdsList;
    
    public int solution(String[] user_id, String[] banned_id) {
        bandIdsList = new HashSet<>();
        findBanIdList(new HashSet<>(), 0, user_id, banned_id);

        return bandIdsList.size();
    }
    
    public void findBanIdList(Set<String> banIds, final int count, final String[] user_id, final String[] banned_id) {
        if (count == banned_id.length) {
            bandIdsList.add(new HashSet<>(banIds));

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (banIds.contains(user_id[i])) {
                continue;
            }

            if (user_id[i].length() != banned_id[count].length()) {
                continue;
            }

            boolean isSame = true;
            for (int j = 0; j < user_id[i].length(); j++) {
                if (banned_id[count].charAt(j) == '*') {
                    continue;
                }

                if (banned_id[count].charAt(j) == user_id[i].charAt(j)) {
                    continue;
                }

                isSame = false;
            }

            if (isSame) {
                banIds.add(user_id[i]);
                findBanIdList(banIds, count + 1, user_id, banned_id);
                banIds.remove(user_id[i]);
            }
        }
    }
}