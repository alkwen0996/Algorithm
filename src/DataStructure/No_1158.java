package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_1158 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        String result = solve(N, K);
        System.out.println(result);
    }

    private static String solve(final int n, final int k) {
        final Deque<Integer> permutation = new ArrayDeque<>();
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<");

        for (int i = 1; i <= n; i++) {
            permutation.offer(i);
        }

        int index = 1;
        while(!permutation.isEmpty()){
            int item = permutation.poll();
            if(index == k && permutation.size() >= 1){
                stringBuilder.append(item).append(", ");
                index = 0;
            }else if(index == k){
                stringBuilder.append(item);
                index = 0;
            }else{
                permutation.add(item);
            }
            index++;
        }

        stringBuilder.append(">");

        return stringBuilder.toString();
    }
}
