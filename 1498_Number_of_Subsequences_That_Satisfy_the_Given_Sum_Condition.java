class Solution {
    int MOD = 1000000007;

    public int numSubseq(int[] nums, int target) 
    {
        Arrays.sort(nums);

        int[] potencia = new int[nums.length];
        potencia[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            potencia[i] = (potencia[i - 1] * 2) % MOD;
        }

        int total=0;
        int j = nums.length-1;
        int i = 0; 
        while(i <= j)
        {
            if(nums[i] + nums[j] <= target)
            {
                total += potencia[j - i];
                total %= MOD;
                i++;
            }
            else
            {
                j--;
            }
        }
        return total;       
    }
}
