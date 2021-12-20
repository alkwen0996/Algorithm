package NHN_CodingTest;

import java.util.*;

public class No_01 {
    private static void solution(final int numberOfOperation, final Operation[] operations) {
        final Map<Integer, Integer> branches = new HashMap<>();
        final StringBuilder stringBuilder = new StringBuilder();

        int branchesIndex = 2;
        branches.put(1, 1);

        for (final Operation operation : operations) {
            if (operation.value == null) {
                branches.put(branchesIndex, branchesIndex);
                branchesIndex++;
            } else {
                branchesIndex = operation.value;
                branches.remove(branchesIndex);
            }
        }

        for (int i = 1; i <= numberOfOperation; i++) {
            if(branches.get(i) != null){
                if(i < numberOfOperation){
                    stringBuilder.append(branches.get(i)).append(" ");
                }else{
                    stringBuilder.append(branches.get(i));
                }
            }
        }

        System.out.println(stringBuilder);
    }

    private static class InputData {
        int numberOfOperation;
        Operation[] operations;
    }

    private static class Operation {
        OperationType type;
        Integer value;

        public Operation(final OperationType type, final Integer value) {
            this.type = type;
            this.value = value;
        }
    }

    private static enum OperationType {
        branch,
        merge;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numberOfOperation = Integer.parseInt(scanner.nextLine());
            inputData.operations = new Operation[inputData.numberOfOperation];

            for (int i = 0; i < inputData.numberOfOperation; i++) {
                String[] temp = scanner.nextLine().split(" ");

                Integer value = null;
                OperationType operationType = OperationType.valueOf(temp[0]);
                if (OperationType.merge == operationType) {
                    value = Integer.valueOf(temp[1]);
                }

                inputData.operations[i] = new Operation(operationType, value);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) {
        InputData inputData = processStdin();

        solution(inputData.numberOfOperation, inputData.operations);
    }

}
