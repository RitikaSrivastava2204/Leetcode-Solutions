/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode l3 = head;
        ListNode previous = null;
        int sum = 0;

        while(l1 != null && l2 != null){
            sum = sum + l1.val + l2.val;
            l3.val = sum%10;
            sum = sum/10;
            l3.next = new ListNode();
            l1 = l1.next;
            l2 = l2.next;
            previous = l3;
            l3 = l3.next;


        }
        while(l1!=null){
            sum = sum + l1.val;
            l3.val = sum%10;
            sum = sum/10;
            l3.next = new ListNode();
            l1 = l1.next;
            previous = l3;
            l3 = l3.next;
        }
        while(l2!=null){
            sum = sum + l2.val;
            l3.val = sum%10;
            sum = sum/10;
            l3.next = new ListNode();
            l2 = l2.next;
            previous = l3;
            l3 = l3.next;
        }
        l3.val = sum;
        if(l3.val == 0){
            previous.next = null;
        }
        return head;
    }
}