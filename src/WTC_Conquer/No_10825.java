package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_10825 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        final List<Student> scoreSort = new ArrayList<>();

        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            scoreSort.add(new Student(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        String result = solve(scoreSort);
        System.out.println(result);
    }

    private static String solve(final List<Student> scoreSort) {
        final StringBuilder stringBuilder = new StringBuilder();

        Collections.sort(scoreSort);

        for (Student student : scoreSort) {
            stringBuilder.append(student.name).append("\n");
        }

        return stringBuilder.toString();
    }

    private static class Student implements Comparable<Student> {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(final String name, final int korean, final int english, final int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(final Student student1) {
            if (korean > student1.korean) {
                return -1;
            } else if (korean < student1.korean) {
                return 1;
            } else {
                if (english > student1.english) {
                    return 1;
                } else if (english < student1.english) {
                    return -1;
                } else {
                    if (math > student1.math) {
                        return -1;
                    } else if (math < student1.math) {
                        return 1;
                    } else {
                        return name.compareTo(student1.name);
                    }
                }
            }
        }

    }
}

