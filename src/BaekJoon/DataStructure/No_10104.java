package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 리스트
public class No_10104 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> positions = new ArrayList<>();
        final List<Integer> friends = new ArrayList<>();
        int K = Integer.parseInt(bufferedReader.readLine()); // 친구 인원수
        int m = Integer.parseInt(bufferedReader.readLine()); // Round

        while (m-- > 0) {
            positions.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int i = 1; i <= K; i++){
            friends.add(i);
        }

        String result = solve(friends, positions);
        System.out.println(result);
    }

    private static String solve(List<Integer> friends, List<Integer> positions) {
        final StringBuilder stringBuilder = new StringBuilder();



        return stringBuilder.toString();
    }
}
