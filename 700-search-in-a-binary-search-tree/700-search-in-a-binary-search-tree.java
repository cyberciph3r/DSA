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
    TreeNode ans = null;
    public TreeNode searchBST(TreeNode root, int val) {
//         TreeNode cur = root;
        
//         while(cur!=null){
//             if(cur.val==val){
//                 return cur;
//             }else if(val>cur.val){
//                 cur = cur.right;
//             }else{
//                 cur = cur.left;
//             }
//         }
        
//         return null;
        
        if(root==null){
            return null;
        }
        
        if(root.val == val ){
            ans = root;
        }
        if(val>root.val){
            searchBST(root.right,val);
        }else{
            searchBST(root.left,val);
        }
        
        return ans;
    }
}