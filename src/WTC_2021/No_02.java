package WTC_2021;

public class No_02 {
    public static void main(String[] args) {
//        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        String[] log = {"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"};
        String answer = solution(log);
        System.out.println(answer);
    }

    private static String solution(final String[] log) {
        final int[] logToMinutes = new int[log.length];

        for (int i = 0; i < log.length; i++) {
            logToMinutes[i] = changeMinute(log[i]);
        }

        int studyTime = 0;
        for (int i = 0; i < log.length; i += 2) {
            studyTime += findStudyTime(logToMinutes[i], logToMinutes[i + 1]);
        }

        return changeHHMM(studyTime);
    }

    private static String changeHHMM(final int studyTime) {
        String time = "";

        int hour = studyTime / 60;
        int minute = studyTime % 60;

        time = String.format("%02d", hour) + ":" + String.format("%02d", minute);

        return time;
    }

    private static int findStudyTime(final int startTIme, final int endTime) {
        int difference = endTime - startTIme;

        if (difference < 5) {
            return 0;
        } else if (difference > 105) {
            return 105;
        }

        return difference;
    }

    private static int changeMinute(final String s) {
        String[] arr = s.split(":");

        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);

        return (hour * 60) + minute;
    }
}
