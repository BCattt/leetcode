package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode algorithm problem 820-Short Encoding Words
 *
 * <p>Given a list of words, we may encode it by writing a reference string {@code S}
 * and a list of indexes {@code A}.
 * For example, if the list of words is {@literal ["time", "me", "bell"]}, we can
 * write it as {@literal S = "time#bell#"} and {@literal indexes = [0, 2, 5]}.
 * Then for each index, we will recover the word by reading from the reference
 * string from that index until we reach a {@literal "#"} character.
 * What is the length of the shortest reference string {@literal S} possible that
 * encodes the given words?</p>
 * <p><b>Example: </b>
 * <pre>
 *     <b>Input:</b> words = ["time", "me", "bell"]
 *     <b>Output:</b> 10
 *     <b>Explanation:</b> S = "time#bell#" and indexes = [0, 2, 5].
 * </pre></p>
 * <p><b>Note: </b>
 * <ol>
 *     <li>{@literal 1 <= words.length <= 2000}.</li>
 *     <li>{@literal 1 <= words[i].length <= 7}.</li>
 *     <li>Each word has only lowercase letters.</li>
 * </ol></p>
 *
 * <p><b>解题思路: </b>
 * 第一个单词必须是完整的(否则无法恢复), 所要做的就是对后续所有单词, 拼接#后, 如果能够在当前
 * 已拼接字符串中找到, 则表示可以恢复, 否则, 不可恢复.</p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class ShortEncodingOfWordsSol {
    public static int minimumLengthEncoding(String[] words) {
        // 如果只有一个单词, 则其长度为该单词拼接#的长度
        if (words.length < 1) {
            return 0;
        }
        StringBuilder result = new StringBuilder(words[0]);
        result.append("#");
        for (int i = 1; i < words.length; ++i) {
            // 无法找到恢复点, 则继续拼接
            if (-1 == result.indexOf(words[i] + "#")) {
                result.append(words[i]).append("#");
            }
        }

        // 从后往前再找一遍
        StringBuilder resultReverse = new StringBuilder(words[words.length - 1]);
        resultReverse.append("#");
        for (int i = words.length - 1; i >= 0; --i) {
            if (-1 == resultReverse.indexOf(words[i] + "#")) {
                resultReverse.append(words[i]).append("#");
            }
        }
        return Math.min(result.length(), resultReverse.length());
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"me", "time"}));
    }
}
