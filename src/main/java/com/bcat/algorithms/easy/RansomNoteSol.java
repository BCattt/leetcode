package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 383 - Ransom Note.
 */
public class RansomNoteSol {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chCount = new int['z' - 'a' + 1];
        char[] chMagazine = magazine.toCharArray();
        for (char c : chMagazine) {
            chCount[c - 'a']++;
        }
        char[] chRansomNote = ransomNote.toCharArray();
        for (char c : chRansomNote) {
            if (chCount[c - 'a'] == 0) {
                return false;
            }
            chCount[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNoteSol sol = new RansomNoteSol();
        String ransomNote;
        String magazine;

        ransomNote = "a";
        magazine = "b";
        System.out.println(sol.canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "ab";
        System.out.println(sol.canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(sol.canConstruct(ransomNote, magazine));
    }
}
