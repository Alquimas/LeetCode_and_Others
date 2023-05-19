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
class Solution 
{
    int caminho = 0;
    private void dfs(TreeNode No, boolean direita, int passos)
        {
            if(No == null) return;
            if(passos > caminho) caminho = passos;
            if(direita)
            {
                dfs(No.right, true, 1);
                dfs(No.left, false, passos+1);
            }
            else
            {
                dfs(No.right, true, passos+1);
                dfs(No.left, false, 1);
            }
        }
    public int longestZigZag(TreeNode root)
    {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return caminho;
    }
}
