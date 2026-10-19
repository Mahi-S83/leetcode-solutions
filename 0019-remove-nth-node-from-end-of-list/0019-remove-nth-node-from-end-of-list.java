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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //counting length of list;
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
          count+=1;
          temp=temp.next;
        }
        int k=count-n+1;
        //find k-1 element
         if (k == 1) {
            return head.next;
        }
        temp=head;
        for(int i=0;i<k-2;i++)
        {
            
            temp=temp.next;
        }
       
        temp.next=temp.next.next;
        return head;
    }
}