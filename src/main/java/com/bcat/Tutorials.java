package com.bcat;

import com.bcat.utils.Utils;

public class Tutorials {
    public static void sortColors(int[] nums) {
        // 记录0和2的位置, 每当出现0或2时, 将其交换到对应的位置即可.
        // 排好序的数组, 0的位置在前, 2的位置在后, 因此, 0的位置从0开始, 2的位置从最后
        // 开始.
        int pos0 = 0, pos2 = nums.length - 1, tmp = 0;
        for (int i = 0; i  <= pos2;) {
            // 如果是0, 则将其放置到正确位置
            if (0 == nums[i]) {
                tmp = nums[pos0];
                nums[pos0++] = nums[i];
                nums[i++] = tmp;
            } else if (2 == nums[i]) {
                tmp = nums[pos2];
                nums[pos2--] = nums[i];
                nums[i] = tmp;
            } else {
                // 未发生交换, 则向前移动
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums); // 0, 0, 1, 1, 2, 2
        System.out.println(Utils.intArray2String(nums));
        nums = new int[]{0};
        sortColors(nums); // 0
        System.out.println(Utils.intArray2String(nums));
        nums = new int[]{1};
        sortColors(nums); // 1
        System.out.println(Utils.intArray2String(nums));
        nums = new int[]{2};
        sortColors(nums); // 2
        System.out.println(Utils.intArray2String(nums));
        nums = new int[]{1,1,1};
        sortColors(nums); // 1,1,1
        System.out.println(Utils.intArray2String(nums));
        nums = new int[]{1, 2, 1, 2, 1, 2};
        sortColors(nums); // 1, 1, 1, 2, 2, 2
        System.out.println(Utils.intArray2String(nums));
        nums = new int[]{2, 0, 1};
        sortColors(nums); // 0, 1, 2
        System.out.println(Utils.intArray2String(nums));
    }
}
