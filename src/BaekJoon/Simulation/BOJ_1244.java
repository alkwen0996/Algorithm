package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1244 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws NumberFormatException, IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int switchCount = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] switchesStatus = new int[switchCount + 1];

        for (int i = 1; i < switchesStatus.length; i++) {
            switchesStatus[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        final int studentCount = Integer.parseInt(bufferedReader.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int gender = Integer.parseInt(stringTokenizer.nextToken());
            final int status = Integer.parseInt(stringTokenizer.nextToken());

            students.add(new Student(gender, status));
        }

        System.out.println(changeSwitchStatus(switchesStatus, students));
    }

    private static StringBuilder changeSwitchStatus(int[] switchesStatus, List<Student> students) {
        for (Student student : students) {
            if (student.gender == 1) {
                changeSwitchByMan(switchesStatus, student.switchNo);
                continue;
            }

            changeSwitchByWoman(switchesStatus, student.switchNo);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < switchesStatus.length; i++) {
            stringBuilder.append(switchesStatus[i]).append(SPACE);

            if (i % 20 == 0) {
                stringBuilder.append(NEW_LINE);
            }
        }

        return stringBuilder;
    }

    private static void changeSwitchByWoman(int[] switchesStatus, int switchNo) {
        changeSwitch(switchesStatus, switchNo);

        int index = 1;
        while (isContinue(switchesStatus, switchNo + index, switchNo - index)) {
            if (switchesStatus[switchNo + index] == 1) {
                switchesStatus[switchNo + index] = 0;
                switchesStatus[switchNo - index] = 0;
            } else {
                switchesStatus[switchNo + index] = 1;
                switchesStatus[switchNo - index] = 1;
            }

            index++;
        }

    }

    private static boolean isContinue(int[] switchesStatus, int rightSwitchIndex, int leftSwitchIndex) {
        return rightSwitchIndex < switchesStatus.length && leftSwitchIndex > 0 && switchesStatus[rightSwitchIndex] == switchesStatus[leftSwitchIndex];
    }

    private static void changeSwitchByMan(int[] switchesStatus, int switchNo) {
        for (int i = switchNo; i < switchesStatus.length; i += switchNo) {
            changeSwitch(switchesStatus, i);
        }

    }

    private static void changeSwitch(final int[] switchesStatus, final int i) {
        if (switchesStatus[i] == 0) {
            switchesStatus[i] = 1;
        } else {
            switchesStatus[i] = 0;
        }
    }

    static class Student {
        private int gender;
        private int switchNo;

        public Student(int gender, int status) {
            super();
            this.gender = gender;
            this.switchNo = status;
        }

    }
}
