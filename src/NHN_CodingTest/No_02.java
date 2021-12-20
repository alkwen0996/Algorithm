package NHN_CodingTest;

import java.util.*;

public class No_02 {

    private static void solution(final int numOfRegion, final int numOfAttackableFrequency, final int[][] frequencies) {
        final List<Integer> attackFrequencies = new ArrayList<>();

        System.out.println("지역수: " + numOfRegion);
        System.out.println("공격가능한 주파수숫자: " + numOfAttackableFrequency);

        for (int i = 0; i < numOfRegion; i++) {
            for (int j = 0; j < frequencies[i].length; j++) {
                System.out.print(frequencies[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("----------------------------");

        final List<Integer> maxes = new ArrayList<>();
        for (int i = 0; i < frequencies.length; i++) {
            int max = Arrays.stream(frequencies[i])
                    .max()
                    .getAsInt();
            maxes.add(max);
        }

        int totalMax = Collections.max(maxes);
        final Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 1; i <= totalMax; i++) {
            numbers.put(i, 0);
        }

        for (int i = 0; i < numOfRegion; i++) {
            for (int j = 0; j < frequencies[i].length; j++) {
                int count = numbers.get(frequencies[i][j]) + 1;
                numbers.put(frequencies[i][j], count);
            }
        }

        for (int i = 1; i <= totalMax; i++) {
            System.out.print(numbers.get(i)+" ");
        }

        int result = attackFrequencies.size();
        System.out.println(result);
    }

    private static class InputData {
        int numOfRegion;
        int numOfAttackableFrequency;
        int[][] frequencies;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            String[] temp = scanner.nextLine().split(" ");
            inputData.numOfRegion = Integer.parseInt(temp[0]);
            inputData.numOfAttackableFrequency = Integer.parseInt(temp[1]);
            inputData.frequencies = new int[inputData.numOfRegion][];

            for (int i = 0; i < inputData.numOfRegion; i++) {
                temp = scanner.nextLine().split(" ");

                int numOfFrequency = Integer.valueOf(temp[0]);
                inputData.frequencies[i] = new int[numOfFrequency];
                for (int j = 0; j < numOfFrequency; j++) {
                    inputData.frequencies[i][j] = Integer.parseInt(temp[j + 1]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) {
        InputData inputData = processStdin();
        solution(inputData.numOfRegion, inputData.numOfAttackableFrequency, inputData.frequencies);
    }
}
