package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1834 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException {

        int num = Integer.parseInt(br.readLine());
        long sum =0;

        for (long i =1;i<num;i++){
                sum += (num+1)*i;
        }//if

        System.out.println(sum);

    }//main
}// class
