class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++)
            for(int j = 0; j < nums2.length; j++)
                dp[i][j] = -1;

        return dinamic(0, 0, dp, nums1, nums2);
    }
    private static int dinamic(int i, int j, int[][] dp, int[] nums1, int[] nums2)
    {
        if(i == nums1.length || j == nums2.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(nums1[i] == nums2[j])
        {
            dp[i][j] = 1 + dinamic(i+1, j+1, dp, nums1, nums2);
        }
        else dp[i][j] = Math.max(dinamic(i, j+1, dp, nums1, nums2), dinamic(i+1, j, dp, nums1, nums2));
        return dp[i][j];
    }
}
