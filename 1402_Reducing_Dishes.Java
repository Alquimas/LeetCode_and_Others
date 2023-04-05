import java.util.Arrays;
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        int i = 0, max=0, sum=0;
        Arrays.sort(satisfaction);

		if(satisfaction[satisfaction.length-1] < 0)
        {
        	return 0;
        }
        while(true)
        {
            for(int j = 0; j<(satisfaction.length-i); j++)
            {
                sum = sum+((j+1)*(satisfaction[i+j]));
            }
            if(max < sum)
            {
                max = sum;
            }
            if(satisfaction[i] >= 0)
            {
                return max;
            }
            
            i++;
            sum=0;
        }
	}
}
