package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class No_42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    private static int solution(final int bridge_length, final int weight, final int[] truck_weights) {
        final Queue<Truck> waitTrucks = new LinkedList<>();
        final Queue<Truck> moveTrucks = new LinkedList<>();

        for (final int truck_weight : truck_weights) {
            waitTrucks.offer(new Truck(truck_weight));
        }

        int time = 0;
        int bridgeWeight = 0;

        while (!waitTrucks.isEmpty() || !moveTrucks.isEmpty()) {
            time++;

            if (moveTrucks.isEmpty()) {
                Truck truck = waitTrucks.poll();
                bridgeWeight += truck.weight;
                moveTrucks.offer(truck);
                continue;
            }

            for (Truck truck : moveTrucks) {
                truck.moveTruck();
            }

            if (!moveTrucks.isEmpty() && moveTrucks.peek().move > bridge_length) {
                Truck truck = moveTrucks.poll();
                bridgeWeight -= truck.weight;
            }

            if (!waitTrucks.isEmpty() && bridgeWeight + waitTrucks.peek().weight <= weight) {
                Truck truck = waitTrucks.poll();
                bridgeWeight += truck.weight;
                moveTrucks.offer(truck);
            }
        }

        return time;
    }

    static class Truck {
        private final int weight;
        private int move;

        public Truck(final int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moveTruck() {
            move++;
        }
    }
}
