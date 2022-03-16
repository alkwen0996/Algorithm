package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputData = bufferedReader.readLine().toUpperCase(Locale.ROOT);

        String result = mostUsedAlphabet(inputData);
        System.out.println(result);
    }

    private static String mostUsedAlphabet(String inputData) {
        List<CountAlphabet> counts = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++){
            if(inputData.indexOf(i) != -1){
                counts.add(new CountAlphabet(countChar(inputData,i),i));
            }
        }

        CountAlphabet maxCountAlphabet = counts.stream()
                .max(Comparator.comparingLong(a -> a.counts))
                .get();

        int  count = 0;
        for (CountAlphabet countAlphabet : counts) {
            if (maxCountAlphabet.counts.equals(countAlphabet.counts)) {
                count++;
            }
        }

        if(count > 1){
            return "?";
        }

        return maxCountAlphabet.alphabet.toString();
    }

    private static long countChar(String inputData, char i) {
        long count = 0;
        for (int j = 0; j < inputData.length(); j++){
            if(inputData.charAt(j) == i){
                count++;
            }
        }
            return count;
    }

    public static class CountAlphabet{
        Long counts;
        Character alphabet;

        public CountAlphabet(Long counts, Character alphabet) {
            this.counts = counts;
            this.alphabet = alphabet;
        }
    }
}
