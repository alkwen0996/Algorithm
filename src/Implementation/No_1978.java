package Implementation;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class No_1978 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int lineCnt = sc.nextInt();

        List <Integer> list = new ArrayList<>();
        int index =0;

        for (int i =0;i<lineCnt;i++){
            int num = sc.nextInt();
            Boolean check = getPrimeNum(num);
            if(check)
                list.add(num);
        }//for_i

        System.out.println(list.size());
    }// main

    private static boolean getPrimeNum(int num){
        boolean chkPrimeNum =true;

        if(num >3) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0)
                    chkPrimeNum = false;
            }
        }else if(num ==1)
            chkPrimeNum = false;

        return chkPrimeNum;
    }// getPrimeNum
}// class
