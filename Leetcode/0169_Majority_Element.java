class Solution {
    public int majorityElement(int[] nums) {
        int retorno = 0;
        int counter = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(counter == 0) retorno = nums[i];
            if(nums[i] == retorno) counter++;
            else counter--;
        }
        return retorno;
    }
}
