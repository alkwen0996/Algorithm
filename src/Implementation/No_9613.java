package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9613 {
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int rowCnt = Integer.parseInt(br.readLine());

        for (int i =0;i<rowCnt;i++){
            st = new StringTokenizer(br.readLine()," ");
            int lineCnt = Integer.parseInt(st.nextToken());

            int [] arr = new int [lineCnt];

            for (int j =0; j<lineCnt;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }// for_j

            long sum =0;
            for (int k =0;k<arr.length-1;k++){
                for (int j=k+1;j<arr.length;j++){
                    sum+=gcd(arr[k],arr[j]);
                }// for_j
            }//for_k
            System.out.println(sum);
        }// for_i

    }// main

    private static long gcd(int x, int y) {

        if(y==0)
            return x;

        return gcd(y,x%y);
    }// gcd
}// class
