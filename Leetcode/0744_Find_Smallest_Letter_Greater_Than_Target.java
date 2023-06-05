class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int K = BinarySearch(letters, 0, letters.length-1, target);

        if(K >= letters.length)
        {
            return letters[0];
        }
        else
        {
            return letters[K];
        }
    }
    public static int BinarySearch(char[] letters, int start, int end, char target)
    {
    //retorna a posicao seguinte a ultima ocorrencia do target
        int min = start;
        int max = end;
        
        if(letters[max] <= target) return max + 1;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (letters[mid] <= target)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
        }
        return min;
    }
}
