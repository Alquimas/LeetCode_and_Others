class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) 
    {
        char[] myStr = answerKey.toCharArray();

        int left = 0, right = 0, t = 0, f = 0, maxLength = Integer.MIN_VALUE;

        for(right = 0; right < myStr.length; right++)
        {
            if(myStr[right] == 'T') t++;
            else f++;

            if(Math.min(t, f) > k)
            {
                maxLength = Math.max(maxLength, right - left);

                if(myStr[left] == 'T') t--;
                else f--;

                left++;
            }
        }

        maxLength = Math.max(maxLength, right - left);

        return (maxLength == Integer.MIN_VALUE) ? myStr.length : maxLength;
    }
}
