package Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2606 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int computerCount = Integer.parseInt(bufferedReader.readLine());
        final int connectComputerCount = Integer.parseInt(bufferedReader.readLine());
        final List<Pair> connectComputerPair = new ArrayList<>();

        for (int i = 0; i < connectComputerCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int key = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());

            connectComputerPair.add(new Pair(key, value));
        }

        int count = solution(connectComputerPair);
        System.out.println(count);
    }

    private static int solution(final List<Pair> connectComputerPair) {
        final Set<Integer> infectedComputers = new HashSet<>();
        infectedComputers.add(1);

        for (Pair pair : connectComputerPair) {
            int key = pair.key;
            int value = pair.value;

            if (checkInfectedComputer(key, infectedComputers)) {
                infectedComputers.add(value);
            }
            System.out.println(infectedComputers.toString());
        }

        return infectedComputers.size() - 1;
    }

    private static boolean checkInfectedComputer(final int key, final Set<Integer> infectedComputers) {
        boolean checkComputer = false;
        for (Integer infectedComputer : infectedComputers) {
            if (key == infectedComputer) {
                checkComputer = true;
                break;
            }
        }
        return checkComputer;
    }

    private static class Pair {
        private int key;
        private int value;

        public Pair(final int key, final int value) {
            this.key = key;
            this.value = value;
        }
    }
}
