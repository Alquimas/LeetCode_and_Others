class Solution 
{
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        Arrays.sort(potions);

        int[] pairs = new int[spells.length];

        for(int i = 0; i < spells.length; i++)
        {   
            pairs[i] = (potions.length-BinarySearch(potions, success, spells[i]));
        }
        return pairs;
    }
    private int BinarySearch(int[] potions, long success, int ratio)
    {
        int max = potions.length-1, min = 0, mid;
        while(min <= max)
        {
            if(((long) potions[0]*ratio) >= success) return 0;

            mid = (max + min)/2;

            if(mid >= potions.length-1)
                return (((long) potions[mid]*ratio) >= success) ? potions.length-1 : potions.length;
            
            if(((long) potions[mid]*ratio) < success && ((long) potions[mid+1]*ratio) >= success)
            {
                return mid+1;
            }
            else if(((long) potions[mid]*ratio) < success)
            {
                min = mid+1;
            }
            else
            {
                max = mid-1;
            }
        }
        return potions.length;
    }
}
