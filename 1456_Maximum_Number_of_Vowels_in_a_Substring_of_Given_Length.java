class Solution {
    public int maxVowels(String s, int k) {
        int sSize = s.length();
        int count = 0;

        // if(sSize <= k)
        // {
        //     for(char c: s.toCharArray())
        //     {
        //         if(isVowel(c)) count ++;
        //     }
        //     return count;
        // }
        int[] aux = new int[sSize];

        int max = 0;

        for(int i = 0; i < sSize; i++)
        {  
            aux[i] = isVowel(s.charAt(i)) ? 1 : 0;
            count += aux[i];
            if(i >= k)  count -= aux[i - k];
            max = Math.max(max, count);
        }

        return max;
    }
    private static boolean isVowel(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}
