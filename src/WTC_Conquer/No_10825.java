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

        scoreSort.sort((student1, student2) -> {
            if (student1.korean > student2.korean) {
                return -1;
            } else if (student1.korean < student2.korean) {
                return 1;
            } else {
                if (student1.english > student2.english) {
                    return 1;
                } else if (student1.english < (student2).english) {
                    return -1;
                } else {
                    if (student1.math > student2.math) {
                        return -1;
                    } else if (student1.math < (student2).math) {
                        return 1;
                    } else {
                        return student1.name.compareTo(student2.name);
                    }
                }
            }
        });

        for (Student student : scoreSort) {
            stringBuilder.append(student.name).append("\n");
        }

        return stringBuilder.toString();
    }

    private static class Student {
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
    }
}
