class LRUCache {
    
    class Node{
        int k;
        int v;
        Node next;
        Node prev;
        Node(int k ,int v){
            this.k = k;
            this.v = v;
            next = null;
            prev = null;
        }
    }
    
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    
    
    HashMap<Integer,Node> hm;
    int cap;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            removeNode(node);
            addNode(node);
            return node.v;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(hm.containsKey(key)){
            removeNode(hm.get(key));
            addNode(node);
            hm.put(key,node);
        }else{
            if(hm.size()<cap){
                addNode(node);
                hm.put(key,node);
            }else{
                hm.remove(tail.prev.k);
                removeNode(tail.prev);
                addNode(node);
                hm.put(key,node);
            }
        }
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addNode(Node node){
        Node temp = head.next;
        temp.prev = node;
        node.next = temp;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */