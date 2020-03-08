package com.bcat.comp.dw21.easy;

public class IncreasingDecreasingStringSol {
    public static String sortString(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char[] cArray = s.toCharArray();
        do {
            char curr = 0xFF;
            // Step 1 smallest character
            int currPos = 0;
            for (int i = 0; i < cArray.length; ++i) {
                if (cArray[i] > 0 && cArray[i] < curr) {
                    curr = cArray[i];
                    currPos = i;
                }
            }
            result.append(curr);
            cArray[currPos] = 0x00;
            do {
                curr = 0xFF;
                currPos = -1;
                for (int i = 0; i < cArray.length; ++i) {
                    if (cArray[i] > result.charAt(result.length() - 1) && cArray[i] < curr) {
                        curr = cArray[i];
                        currPos = i;
                    }
                }
                if (currPos >= 0) {
                    result.append(curr);
                    cArray[currPos] = 0x00;
                }
            } while (currPos >= 0);
            // Find the largest
            curr = 0x00;
            currPos = -1;
            for (int i = 0; i < cArray.length; ++i) {
                if (cArray[i] > curr) {
                    curr = cArray[i];
                    currPos = i;
                }
            }
            if (currPos > 0) {
                result.append(curr);
                cArray[currPos] = 0x00;
                do {
                    curr = 0x00;
                    currPos = -1;
                    for (int i = 0; i < cArray.length; ++i) {
                        if (cArray[i] < result.charAt(result.length() - 1) && cArray[i] > curr) {
                            curr = cArray[i];
                            currPos = i;
                        }
                    }
                    if (currPos >= 0) {
                        result.append(curr);
                        cArray[currPos] = 0x00;
                    }
                } while (currPos >= 0);
            }
        } while (result.length() != s.length());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("rat"));
        System.out.println(sortString("leetcode"));
    }
}
