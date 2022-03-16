package BaekJoon.Implementation;

import java.util.Scanner;

public class No_2438 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int lineCnt = sc.nextInt();

        for(int i=0;i<lineCnt;i++){
            for (int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
