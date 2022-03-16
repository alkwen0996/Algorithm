package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int n = createFibonacci(count);
        System.out.println(n);
    }

    private static int createFibonacci(int count) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        if(count == 0)
            return 0;
        if(count == 1)
            return 1;

        for (int i = 2; i <= count; i++)
            list.add(list.get(i - 2) + list.get(i - 1));
        int n = list.get(list.size() - 1);

        return n;
    }
}
