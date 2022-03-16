package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9095 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++){
            int result = methodNumber(Integer.parseInt(br.readLine()));
            System.out.println(result);
        }
    }

    private static int methodNumber(int number) {
        int result =0;



        return result;
    }
}
