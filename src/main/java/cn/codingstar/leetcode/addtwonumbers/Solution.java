package cn.codingstar.leetcode.addtwonumbers;

/**
 *
 */
public class Solution {

    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> c1 = list1;
        ListNode<Integer> c2 = list2;
        ListNode<Integer> sentinel = new ListNode<>(0);
        ListNode<Integer> d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum = sum / 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode<>(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1) {
            d.next = new ListNode<>(1);
        }
        return sentinel;
    }

    public static void main(String[] args) {

    }
}
