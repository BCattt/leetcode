package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode algorithm problem 1160-Find Words That Can Be Formed by
 * Characters.
 *
 * <p>You are given an array of strings <pre>words</pre> and a string <pre>chars</pre>.
 * A string is <i>good</i> if it can be formed by characters from <pre>chars</pre>
 * (each character can only be used once).
 * Return the sum of lengths of all strings in <pre>words</pre>.
 * </p>
 *
 * <p>
 * <p><b>Example 1:</b>
 * <pre>
 * <b>Input: </b> words = ["cat", "bt", "hat", "tree"], chars = "atach"
 * <b>Output: </b> 6
 * <b>Explanation:</b>
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * </pre>
 * </p>
 * <p>
 * <pre>
 * <b>Example 2:</b>
 * <b>Input: </b> words = ["hello", "world", "leetcode"], chars = "welldonehoneyr"
 * <b>Output: </b> 10
 * <b>Explanation: </b>
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10
 * </pre>
 * </p>
 * </p>
 *
 * <p><b>Note:</b>
 * <ol>
 *     <li>{@literal 1 &lt;= words.length &lt;= 1000}</li>
 *     <li>{@literal 1 &lt;= words[i].length, chars.length &lt;= 100}</li>
 *     <li>All strings contain lowercase English letters only.</li>
 * </ol>
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class FindWordsThatCanBeFormedByCharactersSol {
    public static int countCharacters(String[] words, String chars) {
        int answer = 0;
        char[] charArray = new char[chars.length()];
        for (String word : words) {
            System.arraycopy(chars.toCharArray(),0, charArray, 0, chars.length());
            boolean found = false;
            for (char c : word.toCharArray()) {
                found = false;
                for (int i = 0; i < charArray.length; ++i) {
                    if (charArray[i] == c) {
                        charArray[i] = '\0';
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
            }
            if (found) {
                answer += word.length();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
