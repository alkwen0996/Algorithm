package BaekJoon.Implementation;

import java.util.Scanner;

public class No_17087 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int broNums = sc.nextInt();
        int subinLoc = sc.nextInt();

        int [] brosLoc = new int [broNums];

        for (int i =0; i<broNums;i++){
            int tmp = sc.nextInt();
            brosLoc[i]=Math.abs(subinLoc-tmp);
        }//for_i

            int gcd = brosLoc[0];
            for (int i =0;i<broNums;i++){
                gcd = gcd(gcd,brosLoc[i]);;
            }// for_i
            System.out.println(gcd);


    }// main
    private static int gcd(int fir, int sec){
        if(sec==0){
            return fir;
        }
        return gcd(sec,fir%sec);
    }// gcd
}//class
