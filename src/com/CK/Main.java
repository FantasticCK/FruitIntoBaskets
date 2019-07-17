package com.CK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] tree = new int[]{1,1};
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(tree));
    }
}

class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length < 3) return tree.length;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        for (right = 0; right < tree.length; right++) {
            fruitMap.put(tree[right], fruitMap.getOrDefault(tree[right], 0) + 1);
            if (fruitMap.size() <= 2) {
                max = Math.max(max, (right - left));
            } else if (fruitMap.size() > 2) {
                while (fruitMap.size() > 2) {
                    if (fruitMap.get(tree[left]) == 1) fruitMap.remove(tree[left]);
                    else fruitMap.put(tree[left], fruitMap.get(tree[left]) - 1);
                    left++;
                }
            }
        }
        return max +1 ;
    }
}