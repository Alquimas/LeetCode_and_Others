class Solution { //bit manipulation is too much to me
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; ++i) 
        {
            int sum = 0;
            for (int num : nums)
                sum += (num >> i & 1);
            sum = sum % 3;
            ans |= sum << i;
        }

        return ans;
    }
}
