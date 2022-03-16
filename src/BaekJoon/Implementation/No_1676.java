package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1676 {
    // 뒤에서 0 이나온다 -> 2*5 즉, 2와5가 세트로 존재.
    // 팩토리얼을 살펴보면 2는 5보다 항상 많이 존재하는 규칙이 있음.
    // 5의 개수에 따라 0의수가 좌지우지.
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt =0;

        while(n>=5){
                cnt+=n/5;
                n/=5;
        }

        System.out.println(cnt);

    }// main
}// class
