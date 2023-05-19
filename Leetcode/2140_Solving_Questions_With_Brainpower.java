class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        int n = dp.length;
        dp[n-1] = questions[n-1][0];
        for(int i = n - 2; i > -1; i--)
        {
            if(questions[i][1] + i + 1 < n)
            {
                dp[i] = Math.max(dp[i+1], questions[i][0] + dp[i + questions[i][1] + 1]);
            }
            else dp[i] = Math.max(questions[i][0], dp[i+1]);
        }
        return dp[0];
    }
}
