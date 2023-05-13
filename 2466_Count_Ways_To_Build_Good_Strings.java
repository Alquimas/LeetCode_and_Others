class Solution {
    int MOD = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high];
        int min = Math.min(zero, one);
        int max = Math.max(zero, one);
        int result = 0;
        dp[min-1] += 1;
        dp[max-1] += 1;
        for(int i = min; i < high; i++)
        {
            dp[i] = (dp[i] + dp[i-min])%MOD;
            if(i >= max)
                dp[i] = (dp[i] + dp[i-max])%MOD;
        }
        
        for(int i = low-1; i < high; i++)
            result = (result + dp[i])%MOD;

        return result;
    }
}
