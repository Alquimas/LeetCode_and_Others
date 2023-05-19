class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            dp[i][0] = (matrix[i][0] - '0');
            result = Math.max(result, dp[i][0]);
        }
        for(int i = 0; i < matrix[0].length; i++)
        {
            dp[0][i] = (matrix[0][i] - '0');
            result = Math.max(result, dp[0][i]);
        }
        for(int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] - '0' == 1)
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
                else dp[i][j] = 0;
                result = Math.max(result, dp[i][j]);
            }
        
        return result*result;
    }
}
