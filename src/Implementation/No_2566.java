package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2566 {
    static final int ROW = 9;
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int rowCnt = 0;
        int cnt=0,colCnt = 0;
        StringTokenizer st = null;

        for (int i =0; i <ROW;i++){
            st = new StringTokenizer(br.readLine(), " ");
            cnt =0;
            while (st.hasMoreTokens()) {
                cnt++;
                int num = Integer.parseInt(st.nextToken());
                if (max < num) {
                    max = num;
                    rowCnt=i+1;
                    colCnt=cnt;
                }
            }// while
        } // for_i

        br.close();

        System.out.println(max);
        System.out.println(rowCnt+" "+colCnt);

    }// main
}// class
