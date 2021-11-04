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
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = new ArrayList();
        int result = 0;
        Visit(root, list);
        for(int i=0; i<list.size(); i++)
        {
            result = result + list.get(i);
        }
        return result;
    }
    
    public void Visit(TreeNode root,List<Integer> list)
    {
        if(root != null)
        {
            if (root.left != null && root.left.left == null && root.left.right == null)
            {
                list.add(root.left.val);
            }
            Visit(root.left, list);
    		Visit(root.right, list);
        }
    }
}
