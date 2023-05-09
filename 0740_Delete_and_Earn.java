class Solution {
    public int deleteAndEarn(int[] nums) {
        int MAX=0;

        Map<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            myMap.put(nums[i], myMap.getOrDefault(nums[i], 0) + 1);
            MAX = Math.max(MAX, nums[i]);
        }
        
        if(MAX == 1) return myMap.get(1);
        if(MAX == 2) return (Math.max(2*myMap.get(2), myMap.getOrDefault(1,0)));

        int[] dp = new int[MAX];

        dp[0] = myMap.getOrDefault(1, 0);
        dp[1] = 2*myMap.getOrDefault(2, 0);
        dp[2] = dp[0] + 3*myMap.getOrDefault(3, 0);
        for(int i = 3; i < MAX; i++)
        {
            dp[i] = (i+1)*myMap.getOrDefault(i+1, 0) + Math.max(dp[i-2], dp[i-3]);
        }
        return Math.max(dp[dp.length-1], dp[dp.length-2]);
    }
}
