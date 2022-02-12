package Programmers.Level1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Prg_12901 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        String result = solution(a,b);
        System.out.println(result);
    }

    private static String solution(final int a, final int b) {
    // 1. LocalDate 생성
        LocalDate date = LocalDate.of(2016, a, b);
    // LocalDateTime date = LocalDateTime.of(2021, 12, 25, 1, 15, 20);
        System.out.println(date); // // 2021-12-25
    // 2. DayOfWeek 객체 구하기
        DayOfWeek dayOfWeek = date.getDayOfWeek();
    // 3. 숫자 요일 구하기
        int dayOfWeekNumber = dayOfWeek.getValue();
    // 4. 숫자 요일 출력
        System.out.println(dayOfWeekNumber);

        String today = "";

        switch (dayOfWeekNumber){
            case 1:
                today = "MON";
                break;
            case 2:
                today = "TUE";
                break;
            case 3:
                today = "WED";
                break;
            case 4:
                today = "THU";
                break;
            case 5:
                today = "FRI";
                break;
            case 6:
                today = "SAT";
                break;
            case 7:
                today = "SUN";
                break;
        }

        return today;
    }
}
