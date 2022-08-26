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
    TreeNode parent = null;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null){
            if(parent==null){
                return new TreeNode(val);
            }
            if(val>parent.val){
                parent.right = new TreeNode(val);
            }else{
                parent.left = new TreeNode(val);
            }
        }else{
        
        if(val>root.val){
            parent = root;
            insertIntoBST(root.right,val);
        }else{
            parent = root;
            insertIntoBST(root.left,val);
        }
        }
        
        return root;
        
//         if(root==null){
//             return new TreeNode(val);
//         }
//         TreeNode cur = root,parent=null;
//         while(cur!=null){
//             if(val>cur.val){
//                 parent = cur;
//                 cur = cur.right;
//             }else{
//                 parent = cur;
//                 cur = cur.left;
//             }
//         }
//         if(val>parent.val){
//             parent.right = new TreeNode(val);
//         }else{
//             parent.left = new TreeNode(val);
//         }
        
//         return root;
            
    }
}