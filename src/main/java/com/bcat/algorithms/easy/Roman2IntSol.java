package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode problem 13.Roman to Integer
 *
 *Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class Roman2IntSol {
    public int romanToInt(String s) {
        int sum = 0;
        char prev = 'I';
        int pos = s.length() - 1;
        int curVal = 0, prevVal = 0;
        while(pos >= 0) {
            switch (s.charAt(pos)) {
                case 'I': curVal = 1;   break;
                case 'V': curVal = 5;   break;
                case 'X': curVal = 10;  break;
                case 'L': curVal = 50;  break;
                case 'C': curVal = 100; break;
                case 'D': curVal = 500; break;
                case 'M': curVal = 1000; break;
                default: break;
            }
            switch (prev) {
                case 'I': prevVal = 1;   break;
                case 'V': prevVal = 5;   break;
                case 'X': prevVal = 10;  break;
                case 'L': prevVal = 50;  break;
                case 'C': prevVal = 100; break;
                case 'D': prevVal = 500; break;
                case 'M': prevVal = 1000; break;
                default: break;
            }
            sum += curVal >= prevVal ? curVal : -curVal;
            prev = s.charAt(pos);
            --pos;
        }
        return sum;
    }
}
