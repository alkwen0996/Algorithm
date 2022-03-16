package BaekJoon.Implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class No_11720 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]){

        int cnt = getCount();
        String num = getNumber();

        int result = getSum(cnt, num);
        System.out.println(result);

        sc.close();
    }// main

    private static int getSum(int cnt, String num) {

        int result = 0;
        BigInteger bi = new BigInteger(num);

        for (int i=cnt;i>0;i--){

            result = bi.mod(BigInteger.valueOf(10)).intValue()+result;
            bi = bi.divide(BigInteger.valueOf(10));

        }

        return result;
    }

    private static String getNumber() {

        String num = sc.next();

        return num;
    }

    private static int getCount() {

        int cnt = sc.nextInt();

        return cnt;
    }


}// class
