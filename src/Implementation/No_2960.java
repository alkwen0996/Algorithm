package Implementation;

import java.util.Scanner;

public class No_2960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int result = findDeletePrimeNum(n, k);
        System.out.println(result);

    }

    private static int findDeletePrimeNum(int n, int k) {
        boolean[] primeArr = new boolean[n + 1];
        primeArr[0] = true;
        primeArr[1] = true;

        int idx = 0;
        for (int i = 2; i < primeArr.length; i+=i){
            primeArr[i] = true;
            if(n%i==0)
                break;
            System.out.println("idx:"+idx);
            System.out.println("i:"+i);
            idx +=idx+1;
        }
        int result = idx;

            return result;
    }
}

