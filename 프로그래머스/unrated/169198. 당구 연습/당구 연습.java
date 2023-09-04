import java.awt.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(final int m, final int n, final int startX, final int startY, final int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            List<Point> moveBalls = calculateDistance(m, n, new Point(startX, startY), new Point(balls[i][0], balls[i][1]));

            int minDistance = Integer.MAX_VALUE;
            
            for (int j = 0; j < moveBalls.size(); j++) {
                Point moveBall = moveBalls.get(j);
                int bixX = Math.max(moveBall.x, startX);
                int bixY = Math.max(moveBall.y, startY);
                int smallX = Math.min(moveBall.x, startX);
                int smallY = Math.min(moveBall.y, startY);

                int distance = (int) Math.pow(bixX - smallX, 2) + (int) Math.pow(bixY - smallY, 2);
                minDistance = Math.min(minDistance, distance);
            }

            answer[i] = minDistance;
        }

        return answer;
    }

    public List<Point> calculateDistance(final int m, final int n, final Point startPoint, Point targetPoint) {
        List<Point> balls = new ArrayList<>();

        if (!(startPoint.x == targetPoint.x && startPoint.y > targetPoint.y)) {
            balls.add(new Point(targetPoint.x, targetPoint.y * -1));
        }

        if (!(startPoint.x == targetPoint.x && startPoint.y < targetPoint.y)) {
            balls.add(new Point(targetPoint.x, (2 * n) - targetPoint.y));
        }

        if (!(startPoint.x < targetPoint.x && startPoint.y == targetPoint.y)) {
            balls.add(new Point((2 * m) - targetPoint.x, targetPoint.y));
        }

        if (!(startPoint.x > targetPoint.x && startPoint.y == targetPoint.y)) {
            balls.add(new Point(targetPoint.x * -1, targetPoint.y));
        }

        return balls;
    }
}