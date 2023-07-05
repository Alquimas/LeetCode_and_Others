class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, countL = 0, countR = 0;
        int[] left = new int[n], right = new int[n];

        for(int i = 0; i < n; i++)
        {
            left[i] = countL;
            countL = (nums[i] == 1) ? (countL + 1) : 0;

            right[n - i - 1] = countR;
            countR = (nums[n - i - 1] == 1) ? (countR + 1) : 0;
        }

        int _max = 0;
        for(int i = 0; i < n; i++)
            _max = Math.max(_max, left[i] + right[i]);
        
        return _max;
    }
}
