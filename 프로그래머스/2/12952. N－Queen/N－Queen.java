class Solution {
    public static int count;
    public static int[] map;
    
    public int solution(int n) {
        count = 0;
        map = new int[n];

        backTracking(n, 0);

        return count;
    }
    
    public void backTracking(final int n, final int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            map[row] = i;

            if (valid(row)) {
                backTracking(n, row + 1);
            }
        }
    }

    public boolean valid(final int row) {
        for (int i = 0; i < row; i++) {
            if (map[i] == map[row]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(map[row] - map[i])) {
                return false;
            }
        }

        return true;
    }
}