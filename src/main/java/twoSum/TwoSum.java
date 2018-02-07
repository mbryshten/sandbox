package twoSum;

import java.util.*;

/**
 * Created by mbrysht on 8/24/17.
 */
public class TwoSum {

    /*

    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

     */


    public static void main(String[] args) {

        Solution2 solution = new Solution2();

//        int[] nums = {3, 2, 5, 4};
//
//        int target = 6;
//
//        int[] res = solution.twoSum(nums, target);
//
//        System.out.println(res[0] + ", " + res[1]);
//
//        int[] res2 = solution.twoSum(nums, target);
//
//        System.out.println(res2[0] + ", " + res2[1]);
//
//        int[] res3 = solution.twoSum(new int[]{3, 3}, 6);
//
//        System.out.println(res3[0] + ", " + res3[1]);

        int[] res4 = solution.twoSum(new int[]{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789}, 542);

        System.out.println(res4[0] + ", " + res4[1]);
    }

}


class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    res[0] = i;
                    res[1] = j;

                    return res;
                }
            }
        }
        return res;
    }
}


class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i]) && nums[i] * 2 == target) {

                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }

        Set<Integer> set =  map.keySet();

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {

            Integer key = iterator.next();

            int t = target - key;

            if(map.containsKey(t)) {

                res[0] = map.get(key);
                res[1] = map.get(t);

                return res;
            }


        }

        Arrays.sort(res);

        return res;
    }
}

