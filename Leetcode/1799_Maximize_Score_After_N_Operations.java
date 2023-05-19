class Solution {
    int maximum = 0;
    public int maxScore(int[] nums) {

        pair[] myPairs = new pair[1];
        int k = 0;
        int[] nNums = new int[nums.length-2];

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 1; j < nums.length; j++)
            {
                if(j != i)
                {
                    nNums[k] = nums[j];
                    k++;
                }
            }
            myPairs[0] = new pair(nums[0], nums[i]);
            myFunc(nNums, myPairs);
            k = 0;
        }

        return maximum;
    }	
    private int gcd(int a, int b)
	{   
	    int min = Math.min(b, a);
	    int max = Math.max(b, a);
	    
	    int save;
	    
	    while(max >= min)
	    {
	        if(max % min == 0) return min;
	        save = max;
	        max = min;
	        min = save%min;
	    }
	    return 1;
	}
    private void myFunc(int[] nums, pair[] myPairs)
    {
        if(nums.length == 0)
        {
            maximum = Math.max(maximum, operation(myPairs));
            return;
        }

        int[] nNums = new int[nums.length-2];

        pair[] aA = new pair[myPairs.length+1];

        for(int i = 0; i < myPairs.length; i++)
        {
            aA[i] = myPairs[i];
        }

        int k = 0;

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 1; j < nums.length; j++)
            {
                if(j != i)
                {
                    nNums[k] = nums[j];
                    k++;
                }
            }
            
            aA[myPairs.length] = new pair(nums[0], nums[i]);
            myFunc(nNums, aA);
            k = 0;
        }
    }
    private int operation(pair[] myPairs)
    {
        int[] value = new int[myPairs.length];

        for(int i = 0; i < myPairs.length; i++)
        {
            value[i] = gcd(myPairs[i].first, myPairs[i].second);
        }

        Arrays.sort(value);
        int retorno = 0;

        for(int i = 0; i < myPairs.length; i++)
        {
            retorno += (i+1) * value[i];
        }

        return retorno;
    }
}
class pair
{
    int first;
    int second;
    pair(int a, int b)
    {
        this.first = a;
        this.second = b;
    }
}
