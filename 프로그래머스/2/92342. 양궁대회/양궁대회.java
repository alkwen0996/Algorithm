class Solution {
    public static int max;
    public static int[] answer, lionInfo;
    
    public int[] solution(final int n, final int[] info) {
        max = Integer.MIN_VALUE;
        answer = new int[info.length];
        lionInfo = new int[info.length];

        backTacking(n, info);

        if (max == Integer.MIN_VALUE) {
            return new int[]{-1};
        }

        return answer;
    }
    
    public void backTacking(final int n, final int[] info) {
        if (n == 0) {
            // 우승자 결정
            findWinner(info);

            return;
        }

        // 점수 선택
        for (int i = 0; i < info.length && info[i] >= lionInfo[i]; i++) {
            lionInfo[i]++;
            backTacking(n - 1, info);
            lionInfo[i]--;
        }
    }

    public void findWinner(final int[] info) {
        int lionScore = 0;
        int apeachScore = 0;
        int scoreDiff;

        for (int i = 0; i < info.length; i++) {
            if (lionInfo[i] > info[i]) {
                lionScore += 10 - i;
            } else {
                if (info[i] != 0) {
                    if (lionInfo[i] <= info[i]) {
                        apeachScore += 10 - i;
                    }
                }
            }
        }

        scoreDiff = lionScore - apeachScore;

        if (scoreDiff > 0) {
            if (max < scoreDiff) {
                max = scoreDiff;
                answer = lionInfo.clone();
            } else if (max == scoreDiff) {
                for (int i = lionInfo.length - 1; i >= 0; i--) {
                    if (lionInfo[i] > answer[i]) {
                        answer = lionInfo.clone();

                        break;
                    }
                }
            }
        }
    }
    
}