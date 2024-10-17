class Solution {
    public static int max;
    
    public int solution(int k, int[][] dungeons) {
        max = -1;
        boolean[] isVisited = new boolean[dungeons.length];
        backTracking(0, k, dungeons, isVisited);

        return max;
    }
    
    public void backTracking(final int level, final int k, final int[][] dungeons, final boolean[] isVisited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (isVisited[i]) {
                continue;
            }

            if (dungeons[i][0] > k) {
                continue;
            }

            isVisited[i] = true;
            backTracking(level + 1, k - dungeons[i][1], dungeons, isVisited);
            isVisited[i] = false;
        }

        max = Math.max(level, max);
    }
}