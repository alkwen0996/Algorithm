package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2004 {
    // nCm = n!/(m!*(n-m)!)
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        br.close();

        int twoCnt =0;
        int fiveCnt =0;

        twoCnt = getCntTwo(n,2)-getCntTwo(m,2)-getCntTwo(n-m,2);
        fiveCnt = getCntFive(n,5)-getCntFive(m,5)-getCntFive(n-m,5);

        System.out.println(Math.min(twoCnt,fiveCnt));

    }// main

    private static int getCntTwo(long num, int x){
        int cnt =0;

        while(num>=x){
            cnt+=num/x;
            num/=x;
        }//while

        return cnt;
    }// getCntTwo

    private static int getCntFive(long num, int x){
        int cnt =0;

        while(num>=x){
            cnt+=num/x;
            num/=x;
        }//while

        return cnt;
    }// getCntTwo

}// class
