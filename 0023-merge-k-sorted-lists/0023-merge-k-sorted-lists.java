
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // TC - O(NlogK)... SC - Recursive Stack Space...
        
        return partition(lists,0,lists.length-1);
        
        
//         // TC - O(NlogK)... SC - O(N) for temp...
        
//         if(lists.length==0){
//             return null;
//         }
        
//         int k = lists.length;
        
//         while(k > 1){
            
//             int sz = k%2==0 ? k/2 : (k/2) + 1;
            
//             ListNode temp[] = new ListNode[sz];
//             int j = 0;
                
//             for(int i = 0 ; i < k ; i+=2){
                
//                 ListNode l1 = lists[i];
//                 ListNode l2 = i+1>=k ? null : lists[i+1];
                
//                 temp[j++] = merge(l1,l2);

//             }
            
//             lists = temp.clone();
            
//             k = lists.length;
            
//         }
        
//         return lists[0];
        
        
        
        
        
        // TC - O(N.K)...
        
//         if(lists.length==0){
//             return null;
//         }
        
//         int k = lists.length;
//         ListNode ans = new ListNode();
//         ListNode ansHead = ans;
        
//         while(true){
//             int min = Integer.MAX_VALUE;
//             boolean finished = true;
//             int minPtr = k+1;
            
//             for(int i = 0 ; i < k ; i++){
//                 if(lists[i] !=null && lists[i].val<min){
//                     min = lists[i].val;
//                     minPtr = i;
//                 }
//                 if(lists[i] !=null){
//                     finished = false;
//                 }
//             }
//             if(finished){
//                 break;
//             }
            
//             lists[minPtr] = lists[minPtr].next;
            
//             ans.next = new ListNode(min);
//             ans = ans.next;
//         }
        
//         return ansHead.next;
        
        
       
        
        // TC - O(NlogK)... SC - O(N) for temp...
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         int k = lists.length;
        
//         for(int i = 0 ; i < k ; i++){
//             ListNode listHead = lists[i];
//             while(listHead!=null){
//                 pq.add(listHead.val);
//                 listHead = listHead.next;
//             }
//         }
        
//         ListNode ansHead = new ListNode();
//         ListNode res = ansHead;
        
//         while(!pq.isEmpty()){
//             ansHead.next = new ListNode(pq.poll());
//             ansHead = ansHead.next;
//         }
        
//         return res.next;
    }
    
    public static ListNode partition(ListNode[] lists, int l, int r){
        if(lists.length==0){
            return null;
        }
        if(l<r){
            int m = (l+r)/2;
            ListNode l1 = partition(lists,l,m);
            ListNode l2 = partition(lists,m+1,r);
            return merge(l1,l2);
        }
        return lists[l];
    }
    
    public static ListNode merge(ListNode l1 , ListNode l2){
        
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            dummy.next = l1;
        }else{
            dummy.next = l2;
        }
        
        return head.next;
    }
}