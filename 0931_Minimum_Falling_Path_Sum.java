class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length+2];
        for(int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        for(int i = 0; i < matrix[0].length; i++)
        {
            dp[0][i+1] = matrix[0][i];
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length + 1; j++)
            {
                dp[i][j] = matrix[i][j-1] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
            }
        }
        int retorno = Integer.MAX_VALUE;
        for(int i = 1; i < matrix[0].length + 1; i++)
        {
            retorno = Math.min(dp[matrix.length-1][i], retorno);
        }

        return retorno;
    }
}
