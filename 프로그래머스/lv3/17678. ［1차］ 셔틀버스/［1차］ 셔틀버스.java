import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static final String START_TIME = "09:00";
    
    public String solution(final int n, final int t, final int m, final String[] timetable) {
        int currentTime = changeTimeToMinute(START_TIME);
        int[] changeTimeToMinute = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            changeTimeToMinute[i] = changeTimeToMinute(timetable[i]);
        }

        Queue<Integer> queue = new PriorityQueue<>();

        for (final int j : changeTimeToMinute) {
            queue.add(j);
        }

        List<Integer> passengers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            passengers = new ArrayList<>();

            while (!queue.isEmpty()) {
                if (currentTime < queue.peek()) {
                    break;
                }

                if (passengers.size() == m) {
                    break;
                }

                passengers.add(queue.poll());
            }

            currentTime += t;
        }

        currentTime -= t;
        if (passengers.size() < m) {
            return changeMinuteToTime(currentTime);
        }

        return changeMinuteToTime(passengers.get(passengers.size() - 1) -1);
    }

    public String changeMinuteToTime(int lastTime) {
        String result = "";

        int hour = lastTime / 60;
        int minute = lastTime % 60;

        if (hour < 10) {
            result += "0" + hour;
        } else {
            result += hour;
        }

        result += ":";

        if (minute < 10) {
            result += "0" + minute;
        } else {
            result += minute;
        }

        return result;
    }

    public int changeTimeToMinute(String time) {
        String[] hourMinute = time.split(":");

        int hour = Integer.parseInt(hourMinute[0]) * 60;
        int minute = Integer.parseInt(hourMinute[1]);

        return hour + minute;
    }
}