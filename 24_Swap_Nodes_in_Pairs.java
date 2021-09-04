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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else
        {
            ListNode current = head;
            head = current.next;
            current.next = current.next.next;
            head.next = current;
            if (current.next != null)
            {
                int flag = 0;
                while (flag == 0 && current.next != null)
                { 
                    ListNode before = current;
                    if (current.next.next != null)
                    {
                        current = current.next;
                        ListNode temp = current.next;
                        current.next = current.next.next;
                        temp.next = current;
                        before.next = temp;
                    }
                    else 
                    {
                        flag = 1;
                    }
                }
            }
            return head;
        }
    }
}
