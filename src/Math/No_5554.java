package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_5554 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> moveTimes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            moveTimes.add(Integer.parseInt(bufferedReader.readLine()));
        }

        solve(moveTimes);
    }

    private static void solve(final List<Integer> moveTimes) {
        int totalMoveMinute = 0;
        int totalMoveSecond = 0;

        for (int moveTime : moveTimes) {
            totalMoveMinute += moveTime / 60;
            totalMoveSecond += moveTime % 60;
        }

        if (totalMoveSecond >= 60) {
            totalMoveMinute += totalMoveSecond / 60;
            totalMoveSecond = totalMoveSecond % 60;
        }

        System.out.println(totalMoveMinute + "\n" + totalMoveSecond);
    }
}
