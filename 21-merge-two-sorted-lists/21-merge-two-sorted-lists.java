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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     
        ListNode ans = new ListNode();
        ListNode res = ans;
        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                res.next=list2;
                list2=list2.next;
            }else{
                res.next=list1;
                list1=list1.next;
            }
            res = res.next;
        }
        while(list1!=null){
            res.next=list1;
            res = res.next;
            list1=list1.next;
        }
        while(list2!=null){
            res.next=list2;
            res = res.next;
            list2=list2.next;
        }
        return ans.next;
    }
}