class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) 
    {
        int[] aux = new int[obstacles.length];
        int[] result = new int[obstacles.length];
        int len = 1;
        
        aux[0] = obstacles[0];
        result[0] = 1;
        for(int i = 1; i < obstacles.length; i++)
        {
            if(obstacles[i] < aux[0])
            {
                aux[0] = obstacles[i];
                result[i] = 1;
                continue;
            }
            if(obstacles[i] >= aux[len - 1])
            {
                aux[len++] = obstacles[i];
                result[i] = len;
            }
            else
            {
                result[i] = BinarySearch(aux, -1, len - 1, obstacles[i]) + 1;
                aux[result[i] - 1] = obstacles[i];
            }
        }
        return result;
    }

    static int BinarySearch(int[] array, int min, int max, int value)
    {
        while(max > min + 1)
        {
            int mid = (max + min)/2;
            if(array[mid] > value)
            {
                max = mid;
            }
            else
            {
                min = mid;
            }
        }
        return max; 
    }
}
