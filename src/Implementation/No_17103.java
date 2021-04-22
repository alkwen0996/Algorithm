package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17103 {
    static final int arrSize = 1000000;
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] arr = new boolean[arrSize+1];

        arr[0]=arr[1]=true;
        for (int i =2;i*i<=arrSize;i++){
            if(!arr[i]){
                for (int j = i+i;j<=arrSize;j+=i){
                    arr[j] = true;
                }//for_j
            }//if
        }// for_i

        int lineCnt = Integer.parseInt(br.readLine());

        for (int i =0;i<lineCnt;i++){
            int cnt =0;
            int num = Integer.parseInt(br.readLine());

            for (int j=2;j<=num/2;j++){
                if(!arr[j] && !arr[num-j])
                    cnt++;
            }// for_j

            System.out.println(cnt);
        }// for_i

    }//main
}//class
