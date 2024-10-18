class Solution {
    public static int max;
    public static int[] answer, lionInfo;
    
    public int[] solution(final int n, final int[] info) {
        max = Integer.MIN_VALUE;
        answer = new int[info.length];
        lionInfo = new int[info.length];

        backTacking(n, info, 0);

        if (max == Integer.MIN_VALUE) {
            return new int[]{-1};
        }

        return answer;
    }
    
    public void backTacking(final int n, final int[] info, final int index) {
        if (n == 0) {
            // 우승자 결정
            findWinner(info);

            return;
        }

        // 점수 선택
        for (int i = index; i < info.length; i++) {
            int count = Math.min(n, info[i] + 1);

            lionInfo[i] = count;
            backTacking(n - count, info, i + 1);
            lionInfo[i] = 0;
        }
    }

    public void findWinner(final int[] info) {
        int scoreDiff = getScoreDiff(info);

        if(scoreDiff > 0){
            if (max < scoreDiff) {
                max = scoreDiff;
                answer = lionInfo.clone();
            } else if (max == scoreDiff) {
                for (int i = lionInfo.length - 1; i >= 0; i--) {
                    if(lionInfo[i] != answer[i]){
                        if (lionInfo[i] > answer[i]) {
                            answer = lionInfo.clone();
                        }

                        break;
                    }
                }
            }
        }
    }
    
    public int getScoreDiff(final int[] info) {
        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < info.length; i++) {
            if (lionInfo[i] + info[i] > 0) {
                if (lionInfo[i] > info[i]) {
                    lionScore += 10 - i;
                } else if (lionInfo[i] <= info[i]) {
                    apeachScore += 10 - i;
                }
            }
        }

        return lionScore - apeachScore;
    }
    
}