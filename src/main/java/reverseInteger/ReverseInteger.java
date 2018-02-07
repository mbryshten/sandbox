package reverseInteger;

/**
 * Created by mbrysht on 9/26/17.
 */
public class ReverseInteger {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int res = solution.reverse(153423646);

        System.out.println(res);
    }

}

/*

123

3*10 = 30 + 0 = 30

(30 + 2) * 10 = 320

*/

class Solution {

    public int reverse(int x) {

        int prev = 0;

        boolean minus = false;

        if(x < 0) {

            x = x * -1;

            minus = true;
        }

        int max = Integer.MAX_VALUE;

        while(x > 0) {

            prev = ((x % 10) + prev);

            System.out.println("= " + (max - prev));

            if(x >= 10) {

                if(max / 10 < prev) {

                    return 0;
                }

                prev *= 10;
            }

            x = x / 10;
        }

        if(minus) {

            prev = prev * -1;
        }


        return prev;
    }
}



class Solution2 {

    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}