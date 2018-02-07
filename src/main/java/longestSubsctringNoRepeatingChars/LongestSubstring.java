package longestSubsctringNoRepeatingChars;

import java.util.*;


/**
 * Created by mbrysht on 9/22/17.
 */
public class LongestSubstring {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "";

        /*

        a 0
        d 1 3
        v 2
        f 4
         */

        int n = solution.lengthOfLongestSubstring(s);

        System.out.println(n);

    }

}

class Solution {

    public int lengthOfLongestSubstring(String s) {

        char[] arr = s.toCharArray();

        if(arr.length == 0) return 0;

        int curr_len = 1;
        int max_len = 1;

        Map<String, Integer> map = new HashMap();

        map.put(String.valueOf(arr[0]), 0);

        for (int i = 1; i < arr.length; i ++) {

            Integer num = map.get(String.valueOf(arr[i]));

            if(num == null) {

                num = -1;
            }

            if(num == -1 || i - curr_len > num) {

                curr_len++;

            } else {

                max_len = Math.max(curr_len, max_len);

                curr_len = i - num;
            }

            map.put(String.valueOf(arr[i]), i);
        }

        max_len = Math.max(curr_len, max_len);

        return max_len;
    }
}

class Solution2 {

    public int lengthOfLongestSubstring(String s) {

        char[] arr = s.toCharArray();

        if(arr.length == 0) {

            return 0;
        }

        int max = 0;

        int curr = 1;

        Set<String> set = new HashSet();

        for (int i = 0; i < arr.length - 1; i ++) {

            for(int j = i + 1; j < arr.length; j++) {

                set.add(String.valueOf(arr[j-1]));

                if(!set.contains(String.valueOf(arr[j]))) {

                    curr++;

                } else {

                    break;
                }
            }

            if(curr > max) {

                max = curr;
            }

            set.clear();

            curr = 1;
        }

        if(curr > max) {

            max = curr;
        }

        return max;
    }
}