import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int first = Integer.parseInt(stringTokenizer.nextToken());
        int second = Integer.parseInt(stringTokenizer.nextToken());
        int third = Integer.parseInt(stringTokenizer.nextToken());

        int reward = 0;

        if (first == second && second == third) {
            reward = 10000 + (first * 1000);
        } else if (first == second || second == third || third == first) {
            if (first == second) {
                reward = 1000 + (first * 100);
            } else if (second == third) {
                reward = 1000 + (second * 100);
            }else {
                reward = 1000 + (third * 100);
            }
        } else {
            reward = Math.max(Math.max(first, second), third) * 100;
        }

        System.out.println(reward);
    } // main
} // class
