class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];

        if(obstacleGrid[0][0] != 1) dp[0][1] = 1;
        else return 0;
        for(int i = 1; i < obstacleGrid.length+1; i++)
            for(int j = 1; j < obstacleGrid[0].length+1; j++)
            {
                if(obstacleGrid[i-1][j-1] != 1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else
                    dp[i][j] = 0;
            }

        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
