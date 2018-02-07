package addTwoNumbers;

/**
 * Created by mbrysht on 9/20/17.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode res = null;

//        ListNode l10 = new ListNode(2);
//        ListNode l11 = new ListNode(4);
//        ListNode l12 = new ListNode(8);
//        l10.next = l11;
//        l11.next = l12;
//
//        ListNode l20 = new ListNode(5);
//        ListNode l21 = new ListNode(6);
//        ListNode l22 = new ListNode(4);
//        ListNode l23 = new ListNode(5);
//        l20.next = l21;
//        l21.next = l22;
//        l22.next = l23;
//
//        res = solution.addTwoNumbers(l10, l20);
//
//        do {
//
//            System.out.println(res.val);
//            res = res.next;
//        } while(res != null);
//
//        res = solution.addTwoNumbers(new ListNode(5), new ListNode(5));
//
//        do {
//
//            System.out.println(res.val);
//            res = res.next;
//        } while(res != null);

        System.out.println("!!!!!!!!!!!!!!!!");

        ListNode l91 = new ListNode(9);
        ListNode l92 = new ListNode(9);
        l91.next = l92;

        res = solution.addTwoNumbers(new ListNode(1), l91);

        do {

            System.out.println(res.val);
            res = res.next;
        } while(res != null);

    }

}

/**
 * Definition for singly-linked list.
 * public class addTwoNumbers.ListNode {
 * int val;
 * addTwoNumbers.ListNode next;
 * addTwoNumbers.ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = null;

        ListNode last = null;

        int dig = 0;

        boolean isFirst = true;

        do {

            int l1_val = 0;
            int l2_val = 0;

            if(l1 != null) {

                l1_val = l1.val;
            }

            if(l2 != null) {

                l2_val = l2.val;
            }

            int val = l1_val + l2_val + dig;

            if(val >= 10) {

                val = val % 10;
                dig = 1;
            } else {

                dig = 0;
            }

            if(isFirst) {

                res = new ListNode(val);

                last = res;

            } else {

                ListNode tmp = new ListNode(val);

                last.next = tmp;

                last = tmp;

            }

            isFirst = false;

            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);

        } while(l1 != null || l2 != null);

        if(dig > 0) {

            last.next = new ListNode(1);
        }


        return res;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
