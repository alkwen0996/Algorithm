package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1929 {
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        getPrimeNum(x,y);
    }// main

    private static void getPrimeNum(int x, int y){
        boolean [] isPrime = new boolean[y+1];

        for (int i =2; i<=y;i++){
            isPrime[i]=true;
        }// for_i

        for (int i =2;i<=y;i++){
            for (int j=i+i;j<=y;j+=i){
                if(!isPrime[j]) continue;;
                isPrime[j]=false;
            }//for_j
        }// for_i

        for (int i =x;i<=y;i++){
            if(isPrime[i])
                System.out.println(i);
        }

    }// getPrimeNum
}// class
