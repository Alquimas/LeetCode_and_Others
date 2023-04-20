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
    int maiorlargura=1;
    public int widthOfBinaryTree(TreeNode root) 
    {
        busca(root);

        return maiorlargura;    
    }

    private void dfs(TreeNode esquerda, TreeNode direita, int largura)
    {
       if(esquerda == null || direita == null) return;

       maiorlargura = Math.max(largura, maiorlargura);

       largura = 2*largura;

       dfs(esquerda.left, direita.right, largura);
       dfs(esquerda.right, direita.right, largura-1);
       dfs(esquerda.left, direita.left, largura-1);
       dfs(esquerda.right, direita.left, largura-2);
    }

    private void busca(TreeNode no)
    {
        if(no == null) return;
        if(no.left != null && no.right != null)
        {
            dfs(no.left, no.right, 2);
        }
        busca(no.left);
        busca(no.right);
    }
}
