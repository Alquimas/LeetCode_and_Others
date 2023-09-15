class Solution {
    public int numIdenticalPairs(int[] nums) {

        Arrays.sort(nums);

        int k = nums[0];

        int counter = 1;

        int total = 0;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == k)
                counter++;
            else
            {
                total += counter * (counter - 1) / 2;
                k = nums[i];
                counter = 1;
            }
        }

        total += counter * (counter - 1) / 2;

        return total;

    }
}
