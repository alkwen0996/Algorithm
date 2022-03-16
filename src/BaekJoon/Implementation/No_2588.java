package BaekJoon.Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class No_2588 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int first = sc.nextInt();
        int second = sc.nextInt();



        list.add(first * second);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
