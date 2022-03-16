package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2475 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] arr = new int [5];

        int i =0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int res =0;

        for (i=0;i<arr.length;i++){
            res+=Math.pow(arr[i],2);
        }

        res%=10;

        System.out.println(res);

    }// main
}// class
