package cn.codingstar.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 输入一个整形数组，返回数组中两个元素相加等于一个特定值的两个元素的下标。
 * 你可以假定输入的数组只有一个结果，数组中的元素不会重复。
 */
public class Solution {

    /**
     * 思路：最直接的想法是遍历元素逐个查找，遍历至第i个元素时，检查第i个元素后(i + 1)的所有元素，看是否满足条件。
     * 复杂度：o(n^2)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        // 检查数组的元素是否>=2
        if (numbers.length < 2) {
            return null;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }

    /**
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_twoPassHashTable(int[] numbers, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            table.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (table.containsKey(complement)) {
                return new int[]{i, table.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_onePassHashTable(int[] numbers, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (table.containsKey(complement)) {
                return new int[]{table.get(complement), i};
            }
            table.put(numbers[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 9, 11};
        int target = 12;
        int[] result = twoSum(array, target);
        System.out.printf("brute method ：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        result = twoSum_twoPassHashTable(array, target);
        System.out.printf("hash method (two pass)：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        result = twoSum_onePassHashTable(array, target);
        System.out.printf("hash method (one pass)：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
