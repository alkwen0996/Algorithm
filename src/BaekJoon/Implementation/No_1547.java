package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1547 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {


        boolean [] arr = {false, true, false, false};
        int cnt = Integer.parseInt(br.readLine());
        int fir=0,sec=0;

        for (int i =0; i<cnt;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {

                fir = Integer.parseInt(st.nextToken());
                sec = Integer.parseInt(st.nextToken());

            } //while

            Boolean tmp = arr[fir];
            arr[fir] = arr[sec];
            arr[sec] = tmp;
            System.out.println("arr[fir]: "+arr[fir]+" / arr[sec]: "+arr[sec]);

        }// for_i

        for (int i =0; i <arr.length;i++){
            if(arr[i])
                System.out.println(i);
        }
    }// main
}// class

/* 풀이 1
    int [] arr = {1,2,3};
    int cnt = Integer.parseInt(br.readLine());

        for (int i =0; i<cnt;i++) {
    Boolean flagFir = true,flagSec = true;
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int fir=0,sec=0;

    while (st.hasMoreTokens()) {
    fir = Integer.parseInt(st.nextToken());
    sec = Integer.parseInt(st.nextToken());
    } // while

    for (int j =0;j<arr.length;j++){
    if(fir == arr[j] && flagFir) {
    fir = j;
    flagFir = false;
    }
    if(sec == arr[j]  && flagSec) {
    sec = j;
    flagSec = false;
    }
    }// for_j

    int tmp = 0;
    tmp = arr[fir];
    arr[fir] = arr[sec];
    arr[sec] = tmp;
    }// for_i

    br.close();
    System.out.println(arr[0]);*/
