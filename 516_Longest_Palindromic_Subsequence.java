class Solution 
{
    public int longestPalindromeSubseq(String s) 
    {
        char[] y = s.toCharArray();
        char c;
        
        for(int i = 0; i<s.length()/2; i++)
        {
            c = y[i];
            y[i] = y[s.length() - 1 - i];
            y[s.length() - 1 - i] = c;
        }
      
        int m = s.length();
        int[][] dp = new int[m + 1][m + 1];
        for(int i = 0; i < m + 1; i++)
        {
            for(int j = 0;j < m + 1; j++)
            {
                dp[i][j] = -1;
            }
        }

        String x = null;
        x = x.valueOf(y);

        return lcs(x, s, m, m, dp);
    }

    static int lcs(String X, String Y, int m, int n, int[][] dp)
    { 
      if (m == 0 || n == 0)
        return 0;
 
      if (dp[m][n] != -1)
        return dp[m][n];
 
      if(X.charAt(m - 1) == Y.charAt(n - 1))
      {
        dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
        return dp[m][n];
      }
 
      dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp), lcs(X, Y, m - 1, n, dp));
      return dp[m][n];
    }
}
