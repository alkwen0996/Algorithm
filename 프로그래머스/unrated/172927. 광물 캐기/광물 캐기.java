class Solution {
    public final String DIAMOND = "diamond";
    public final String IRON = "iron";
    private int minimalFatigue;
    
    public int solution(final int[] picks, final String[] minerals) {
        minimalFatigue = Integer.MAX_VALUE;

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) {
                continue;
            }

            int[] copyPicks = new int[picks.length];
            System.arraycopy(picks, 0, copyPicks, 0, picks.length);
            copyPicks[i]--;

            dfs(i, copyPicks, minerals, 0, 0);
        }

        return minimalFatigue;
    }

    public void dfs(final int pickType, int[] picks, final String[] minerals, int fatigue, int startIndex) {
        int mineralCount = 0;

        for (int i = startIndex; i < minerals.length; i++) {
            if (mineralCount >= 5) {
                break;
            }

            String mineral = minerals[i];

            if (pickType == 0) {
                fatigue += 1;
            } else if (pickType == 1) {
                if (DIAMOND.equals(mineral)) {
                    fatigue += 5;
                } else {
                    fatigue += 1;
                }
            } else {
                if (DIAMOND.equals(mineral)) {
                    fatigue += 25;
                } else if (IRON.equals(mineral)) {
                    fatigue += 5;
                } else {
                    fatigue += 1;
                }
            }

            mineralCount++;
        }

        startIndex += mineralCount;

        if (fatigue >= minimalFatigue) {
            return;
        }

        if (isAllPicksUsed(picks) || startIndex >= minerals.length) {
            minimalFatigue = fatigue;

            return;
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] <= 0) {
                continue;
            }

            int[] copyPicks = new int[picks.length];
            System.arraycopy(picks, 0, copyPicks, 0, picks.length);
            copyPicks[i]--;
            dfs(i, copyPicks, minerals, fatigue, startIndex);
        }

    }

    public boolean isAllPicksUsed(final int[] picks) {
        return picks[0] == 0 && picks[1] == 0 && picks[2] == 0;
    }
}