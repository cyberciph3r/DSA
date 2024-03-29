
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null){
            return null;
        }
        
        Node cur = head;
        
        // step-1 : creating new nodes in btw the original nodes
        
        while(cur != null){
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        
        // step-2 : assigning random ptrs
        
        cur = head;
        
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // step-3 : separating the nodes
        
        cur = head;
        Node ans = head.next;
        Node ptr2 = head.next;
        
        while(cur != null){
            cur.next = cur.next.next;
            if(ptr2.next == null){
                break;
            }
            ptr2.next = ptr2.next.next;
            
            cur = cur.next;
            ptr2 = ptr2.next;
        }
        
        return ans;
    }
}