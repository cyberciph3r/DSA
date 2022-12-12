/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static PriorityQueue<Integer> pq;
    
    Solution(){
         pq = new PriorityQueue<>();
    }
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        while(k-- !=1){
            pq.poll();
        }
        
        return pq.peek();
    }
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        
        inOrder(root.left);
        pq.add(root.val);
        inOrder(root.right);
    }
}