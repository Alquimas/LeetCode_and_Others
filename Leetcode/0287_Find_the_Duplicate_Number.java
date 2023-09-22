class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums.length;
        int fast = nums.length;

        for(;;)
        {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
            if (slow == fast)
                break;
        }

        int finder = nums.length;

        for(;;)
        {
            slow = nums[slow - 1];
            finder = nums[finder - 1];

            if(slow == finder)
                return slow;
        }
    }
}
