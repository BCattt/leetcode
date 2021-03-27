package com.bcat.algorithms.easy;

/**
 * Solution for leetcode - 1603 - Design Parking System.
 */
public class DesignParkingSystemSol {
    static class ParkingSystem {
        private final int[] parkingLots = new int[3 + 1];
        private static final int BIG_CAR = 1;
        private static final int MEDIUM_CAR = 2;
        private static final int SMALL_CAR = 3;
        public ParkingSystem(int big, int medium, int small) {
            parkingLots[BIG_CAR] = big;
            parkingLots[MEDIUM_CAR] = medium;
            parkingLots[SMALL_CAR] = small;
        }

        public boolean addCar(int carType) {
            if (parkingLots[carType] > 0) {
                --parkingLots[carType];
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
