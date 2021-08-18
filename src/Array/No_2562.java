package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Number> inputNumbers = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            inputNumbers.add(new Number(Integer.parseInt(bufferedReader.readLine()), i + 1));
        }

        Number resultNumber = findMaximum(inputNumbers);
        System.out.println(resultNumber.number+"\n"+ resultNumber.index);
    }

    private static Number findMaximum(List<Number> inputNumbers) {
        return inputNumbers.stream().max(Comparator.comparing(a -> a.number)).get();
    }

    private static class Number {
        Integer number;
        Integer index;

        public Number(int number, int i) {
            this.number = number;
            this.index = i;
        }
    }
}
