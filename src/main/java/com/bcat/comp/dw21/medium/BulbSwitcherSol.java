package com.bcat.comp.dw21.medium;

public class BulbSwitcherSol {
    public static int numTimesAllBlue(int[] light) {
        int timeAllBulbBlue = 0;
        // 灯泡状态0-未打开, 1-打开, 2-蓝色
        int[] bulbStatus = new int[light.length];
        for (int i = 0 ; i < light.length; ++i) {
            if (isAllBlue(bulbStatus, light[i] - 1, i + 1)) {
                ++timeAllBulbBlue;
            }
        }
        return timeAllBulbBlue;
    }

    public static boolean isAllBlue(int[] bulbStatus, int i, int currentOnLights) {
        int blueLights = 0;
        // 只需要检查该灯前面的灯是否都为蓝色, 然后检查该灯后面的灯, 全部置为蓝色
        // 如果是第一盏灯, 则直接变成蓝色
        if (i == 0) {
            bulbStatus[i] = 2;
            blueLights = 1;
            // 将其后面开着的灯变成蓝色
            for (int k = i + 1; k < bulbStatus.length; ++k) {
                if (bulbStatus[k] == 1) {
                    bulbStatus[k] = 2;
                    ++blueLights;
                } else if (bulbStatus[k] == 0) {
                    break;
                }
            }
        } else if (bulbStatus[i - 1] == 2) {
            bulbStatus[i] = 2;
            blueLights = i + 1;
            // 将其后面开着的灯变成蓝色
            for (int k = i + 1; k < bulbStatus.length; ++k) {
                if (bulbStatus[k] == 1) {
                    bulbStatus[k] = 2;
                    ++blueLights;
                } else if (bulbStatus[k] == 0) {
                    break;
                }
            }
        } else {
            bulbStatus[i] = 1;
        }
        return currentOnLights == blueLights;
    }

    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{1}));
        System.out.println(numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
        System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        System.out.println(numTimesAllBlue(new int[]{4, 1, 2, 3}));
        System.out.println(numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5}));
        System.out.println(numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6}));
    }
}

