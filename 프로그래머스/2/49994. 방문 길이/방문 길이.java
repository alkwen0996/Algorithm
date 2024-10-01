import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] moveX = {1, 0, -1, 0};
        int[] moveY = {0, 1, 0, -1};

        char[] charArray = dirs.toCharArray();
        Set<String> answer = new HashSet<>();
        int currentX = 5, currentY = 5;

        for (int i = 0; i < charArray.length; i++) {
            int nextX = 0;
            int nextY = 0;

            if (charArray[i] == 'U') {
                nextX = currentX + moveX[2];
                nextY = currentY + moveY[2];
            } else if (charArray[i] == 'L') {
                nextX = currentX + moveX[3];
                nextY = currentY + moveY[3];
            } else if (charArray[i] == 'R') {
                nextX = currentX + moveX[1];
                nextY = currentY + moveY[1];
            } else if (charArray[i] == 'D') {
                nextX = currentX + moveX[0];
                nextY = currentY + moveY[0];
            }

            if (checkBoundary(nextX, nextY)) {
                continue;
            }

            answer.add(currentX + "," + currentY + "," + nextX + "," + nextY);
            answer.add(nextX + "," + nextY + "," + currentX + "," + currentY);

            currentX = nextX;
            currentY = nextY;
        }

        return answer.size() / 2;
    }
    
    public boolean checkBoundary(final int nextX, final int nextY) {
        return nextX < 0 || nextY < 0 || nextX >= 11 || nextY >= 11;
    }
}