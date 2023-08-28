class Solution {
    public int maxGap;
    public int[] answer, lionInfo;
    
    public int[] solution(final int n, final int[] info) {
        maxGap = Integer.MIN_VALUE;
        lionInfo = new int[info.length];
        answer = new int[info.length];

        dfs(0, n, info, lionInfo);

        if (maxGap == Integer.MIN_VALUE) {
            return new int[]{-1};
        }

        return answer;
    }
    
    public void dfs(final int startIndex, final int n, final int[] info, final int[] lionInfo) {
        if (n == 0) {
            checkWinner(info, lionInfo);

            return;
        }

        for (int i = startIndex; i < info.length; i++) {
            lionInfo[i]++;
            dfs(i, n - 1, info, lionInfo);
            lionInfo[i]--;
        }

    }

    private void checkWinner(final int[] info, final int[] lionInfo) {
        int aPeachScore = 0;
        int lionScore = 0;
        int scoreGap;

        for (int i = 0; i < info.length; i++) {
            if (info[i] > lionInfo[i]) {
                aPeachScore += (10 - i);
            } else {
                if (lionInfo[i] == 0 && info[i] == 0) {
                    continue;
                }

                if (info[i] == lionInfo[i]) {
                    aPeachScore += (10 - i);
                } else {
                    lionScore += (10 - i);
                }
            }
        }

        scoreGap = lionScore - aPeachScore;

        if (scoreGap > 0) {
            if (maxGap < scoreGap) {
                maxGap = scoreGap;
                answer = lionInfo.clone();

            } else if (maxGap == scoreGap) {
                if (checkArr(answer, lionInfo)) {
                    answer = lionInfo.clone();
                }
            }
        }

    }

    public boolean checkArr(final int[] answer, final int[] lionInfo) {
        for (int i = lionInfo.length - 1; i >= 0; i--) {
            if (answer[i] == lionInfo[i]) {
                continue;
            }

            return answer[i] <= lionInfo[i];
        }

        return false;
    }
    
}