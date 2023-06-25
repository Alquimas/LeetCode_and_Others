class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int[] medsum = new int[n];
        for(int i = 0; i < n; i++)
        {
            medsum[i] = -1;
        }
        if(nums.length < 2*k + 1)
        {
            return medsum;
        }
        for(int i = 0; i < k; i++)
        {
            sum += (nums[i] + nums[2*k - i]);
        }
        sum += nums[k];
        for(int i = k; i < n - k - 1; i++)
        {
            medsum[i] = (int) ((sum)/(2*k + 1));
            sum -= nums[i - k];
            sum += nums[i + k + 1];
        }
        medsum[n - k - 1] = (int) (sum/(2*k + 1));
        return (medsum);
    }
}
