package BaekJoon.Implementation;

import java.util.Scanner;

public class No_2609 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int min = 1;

        if(x>y)
            min = y;
        else
            min = x;

        int cd =1; // 공약수

        for (int i =2;i<=min;i++){
            if(x%i ==0 && y%i == 0){
                cd = i;
            }
        }

        int a = x/cd;
        int b = y/cd;

        System.out.println(cd);
        System.out.println(a*b*cd);

        sc.close();

    }//main
}// class
