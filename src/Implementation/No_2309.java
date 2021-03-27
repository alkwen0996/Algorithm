package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int arrLeg = 9;
    public static void main(String args[])throws IOException {

        int [] arr = new int[arrLeg];
        int tmp,sum=0;

        for (int i =0;i<arrLeg;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }// for

        int x=0,y=0;
        out:
        for (int i =0;i<arrLeg-1;i++){
            for (int j =i+1; j<arrLeg;j++){
                tmp = sum-(arr[i]+arr[j]);
                if(tmp == 100){
                    x = arr[i];
                    y = arr[j];
                    break out;
                }//if
            }//for_j
        }//for_i

        Arrays.sort(arr);

        for (int i =0; i<arrLeg;i++){
            if(arr[i] != x && arr[i] != y){
                System.out.println(arr[i]);
            }
        }// arr[i]

    }// main
}// class
