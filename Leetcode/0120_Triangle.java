import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][triangle.get(n-1).size()+1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        int k = 1;
        dp[0][0] = 0;
        dp[0][1] = 0; 
        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < k+1; j++)
            {
                dp[i][j] = triangle.get(i-1).get(j-1) + Math.min(dp[i-1][j-1], dp[i-1][j]);
            }
            k++;
        }
        int retorno = Integer.MAX_VALUE;
        for(int i = 1; i < k; i++)
        {
            retorno = Math.min(retorno, dp[n][i]);
        }
        return retorno;
    }   
}
