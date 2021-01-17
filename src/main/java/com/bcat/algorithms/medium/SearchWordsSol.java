package com.bcat.algorithms.medium;

/**
 * Solution for Leetcode algorithms 79 - Word Search.
 *
 *<p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *</p>
 *<p>
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *  
 *</p>
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * <p>
 *     典型的回溯算法.
 * </p>
 */
public class SearchWordsSol {
    static boolean exist(char[][] board, String word) {
        return false;
    }
}
