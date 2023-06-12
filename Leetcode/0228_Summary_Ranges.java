class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> myList = new ArrayList<>();
        if(nums.length == 0)
        {
            return myList;
        }
        if(nums.length == 1)
        {
            myList.add(Integer.toString(nums[0]));
            return myList;
        }
        int start = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] - 1 == nums[i - 1])
            {
                continue;
            }
            if(nums[i - 1] == start)
            {
                myList.add(Integer.toString(start));
                start = nums[i];
                continue;
            }
            myList.add(Integer.toString(start) + "->" + Integer.toString(nums[i - 1]));
            start = nums[i];
        }
        if(nums[nums.length - 1] - 1 == nums[nums.length - 2])
        {
            myList.add(Integer.toString(start) + "->" + Integer.toString(nums[nums.length - 1]));
        }
        else
        {
            myList.add(Integer.toString(nums[nums.length - 1]));
        }
        return myList;
    }
}
