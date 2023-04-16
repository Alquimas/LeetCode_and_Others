class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int[] retorno = {0, 0};
        for(int j = 0; j<nums.length; j++)
        {
            for(int i = j+1; i<nums.length; i++)
            {
                if(nums[i] + nums[j] == target)
                {
                    return new int[] {i, j};
                }
            }
        }
        //sempre ha solucao: o java que necessita de alguma opcao de retorno fora dos desvios
        return null;
    }  
}

//solucao com hash table

class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        //lembre que um Map<K, L> é composto por K = keys e L = elementos
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) 
        {
            int complement = target - nums[i];
            if (map.containsKey(complement)) 
            {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        //sempre ha solucao: o java que necessita de alguma opcao de retorno fora dos desvios
        return null;
    }
