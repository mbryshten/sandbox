package palindromeNumber;

/**
 * Created by mbrysht on 9/27/17.
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        Solution2 solution = new Solution2();

        boolean res = solution.isPalindrome(1234);

        System.out.println(res);

    }
}

class Solution2 {

    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;

        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }

        return (x==rev || x==rev/10);
    }
}

class Solution {

    public boolean isPalindrome(int x) {

        String str = Integer.toString(x);

        for(int i = 0; i < str.length()/2; i++) {

            if(str.charAt(i) == str.charAt(str.length() - 1 - i)) {

                continue;
            } else {

                return false;
            }
        }

        return true;
    }
}
