package Implementation;

import java.util.Scanner;

public class No_1934 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int lineCnt = sc.nextInt();

        for (int i =0;i<lineCnt;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int gcd = gcd(x,y);

            System.out.println(x*y/gcd);
        }// for_i
    }// main

    private static int gcd(int x, int y) {

        int r = x%y;

        if(r==0)
            return y;

        return gcd(y,r);
    }//gcd
}// class
