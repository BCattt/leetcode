package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangleSol {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>(numRows);
        if (numRows == 1) {
            results.add(Collections.singletonList(1));
        } else {
            results.add(Collections.singletonList(1));
            List<Integer> last = Arrays.asList(1, 1);
            results.add(last);
            for (int i = 2; i < numRows; ++i) {
                List<Integer> result = new ArrayList<>(i);
                result.add(1);
                for (int j = 1; j < last.size(); ++j) {
                    result.add(last.get(j - 1) + last.get(j));
                }
                result.add(1);
                results.add(result);
                last = result;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        PascalTriangleSol sol = new PascalTriangleSol();
        int numRows;
        numRows = 1;
        System.out.println(sol.generate(numRows));
        numRows = 2;
        System.out.println(sol.generate(numRows));
        numRows = 3;
        System.out.println(sol.generate(numRows));
        numRows = 4;
        System.out.println(sol.generate(numRows));
        numRows = 5;
        System.out.println(sol.generate(numRows));
    }
}
