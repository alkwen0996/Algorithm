package WTC_2021;

public class DemoTest {
    public static void main(String[] args) {
        int[][] positions = {{1, 1}, {2, 2}, {1, 2}};
//        int[][] positions = {{1, 4}, {3, 4}, {3, 10}};

        int[] result = solution(positions);
        System.out.println(result[0] + "/" + result[1]);
    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        if (v[0][0] == v[1][0]) {
            answer[0] = v[2][0];
        } else if (v[0][0] == v[2][0]) {
            answer[0] = v[1][0];
        } else if (v[1][0] == v[2][0]) {
            answer[0] = v[0][0];
        }


        if (v[0][1] == v[1][1]) {
            answer[1] = v[2][1];
        } else if (v[0][1] == v[2][1]) {
            answer[1] = v[1][1];
        } else if (v[1][1] == v[2][1]) {
            answer[1] = v[0][1];
        }

        return answer;
    }
}

// 8 8 7 6
