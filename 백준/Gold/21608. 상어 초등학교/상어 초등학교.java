import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     * 1. 각 칸을 4방탐색으로 인접칸에 좋아하는 학생이 몇명인지 최댓값을 구한다.
     * 2. 만약 최댓값이 같은경우가 있다면 4방탐색을 통해 비어있는 칸이 가장 많은 칸을 정한다.
     * 3. 비어있는 칸도 같은 경우가 있다면 행의 번호가 작은 칸을 정한다.
     * 4. 행의 번호까지 같다면 열의 번호가 가장 작은 칸으로 자리를 정한다.
     * 5. 배치된 칸에 있는 학생의 만족도를 구한다.
     *   5-1. 만족도는 4방탐색을 통해 각 학생이 좋아하는 학생수를 더한 값이다.
     *   5-2. 만족도가 0, 1 -> 1, 2 -> 10, 3 -> 100, 4 -> 1000
     * */

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int lengthOfLine = Integer.parseInt(bufferedReader.readLine());

        final Student[][] classRoom = new Student[lengthOfLine][lengthOfLine];
        final List<Student> students = new ArrayList<>();

        for (int i = 0; i < (lengthOfLine * lengthOfLine); i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int[] likeNo = new int[4];
            final int studentNo = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < 4; j++) {
                likeNo[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            students.add(new Student(studentNo, likeNo));
        }

        sumSatisfaction(classRoom, students);
    }

    private static void sumSatisfaction(final Student[][] classRoom, final List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            final Student student = students.get(i);
//            System.out.println("==============" + student.toString());
            Point currentSeat = null;

            int maximumLike = Integer.MIN_VALUE;
            int maximumEmptySeat = Integer.MIN_VALUE;

            for (int j = 0; j < classRoom.length; j++) {
                for (int k = 0; k < classRoom.length; k++) {
                    Point isMoveSeat = new Point(j, k);

                    if (classRoom[j][k] != null) {
                        continue;
                    }

                    int[] count = countEmptySeat(student, classRoom, isMoveSeat);

                    if (maximumLike < count[1]) { // 좋아하는 친구가 근처에 더 많은 자리 확인
//                        System.out.println("잘: " + isMoveSeat.toString());
                        currentSeat = isMoveSeat;
                        maximumLike = count[1];
                        maximumEmptySeat = count[0];
                    } else if (maximumLike == count[1]) {
                        /*System.out.println("빈자리 개수: " + count[0]);
                        System.out.println("최대 빈자리 개수: " + maximumEmptySeat);*/

                        if (maximumEmptySeat < count[0]) { // 빈자리가 더 큰쪽으로 자리이동.
                            currentSeat = isMoveSeat;
                            maximumEmptySeat = count[0];
                        } else if (maximumEmptySeat == count[0]) {
                            if (currentSeat == null) { // 현재 지정된 자석이 없으면 해당 자리에 착석.
                                currentSeat = isMoveSeat;
                            } else {
                                if (currentSeat.x > isMoveSeat.x) {
                                    currentSeat = isMoveSeat;
                                } else {
//                                    System.out.println(isMoveSeat.toString());
                                    if (currentSeat.x == isMoveSeat.x) { // 행번호가 같으면
                                        if (currentSeat.y > isMoveSeat.y) { // 열번호가 더 작은 열인지 확인
                                            currentSeat = isMoveSeat;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            student.selectSeat(currentSeat);
            classRoom[currentSeat.x][currentSeat.y] = student;

            /*for (int m = 0; m < classRoom.length; m++) {
                System.out.println(Arrays.toString(classRoom[m]));
            }

            System.out.println();*/
        }

        int sumSatisfaction = 0;

        for (int i = 0; i < classRoom.length; i++) {
            for (int j = 0; j < classRoom.length; j++) {
                int satisfaction = countEmptySeat(classRoom[i][j], classRoom);

                if (satisfaction == 0) {
                    continue;
                }

                if (satisfaction == 1) {
                    sumSatisfaction++;
                    continue;
                }

                if (satisfaction == 2) {
                    sumSatisfaction += 10;
                    continue;
                }

                if (satisfaction == 3) {
                    sumSatisfaction += 100;
                    continue;
                }

                sumSatisfaction += 1000;
            }
        }

        System.out.println(sumSatisfaction);
    }

    private static int countEmptySeat(final Student student, final Student[][] classRoom) {
        int satisfaction = 0;

        for (int j = 0; j < dx.length; j++) {
            int nextX = student.seat.x + dx[j];
            int nextY = student.seat.y + dy[j];

            if (nextX < 0 || nextY < 0 || nextX >= classRoom.length || nextY >= classRoom.length) {
                continue;
            }

            for (int i = 0; i < student.likeNo.length; i++) {
                if (classRoom[nextX][nextY].no == student.likeNo[i]) {
                    satisfaction++;
                }
            }
        }

        return satisfaction;
    }


    private static int[] countEmptySeat(final Student student, final Student[][] classRoom, final Point currentSeat) {
        int[] count = {0, 0}; // 0번은 빈자리 카운트, 1번은 likeCount

        for (int j = 0; j < dx.length; j++) {
            int nextX = currentSeat.x + dx[j];
            int nextY = currentSeat.y + dy[j];

            if (nextX < 0 || nextY < 0 || nextX >= classRoom.length || nextY >= classRoom.length) {
                continue;
            }

            if (classRoom[nextX][nextY] == null) {
                count[0]++;
            }

            for (int i = 0; i < student.likeNo.length; i++) {
                if (classRoom[nextX][nextY] == null) {
                    continue;
                }

                if (classRoom[nextX][nextY].no == student.likeNo[i]) {
                    count[1]++;
                }
            }
        }

        return count;
    }

    static class Student {
        private int no;
        private int[] likeNo;

        private Point seat;

        public Student(final int no, final int[] likeNo) {
            this.no = no;
            this.likeNo = likeNo;
        }

        public void selectSeat(final Point point) {
            this.seat = point;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", likeNo=" + Arrays.toString(likeNo) +
                    '}';
        }

    }

}

