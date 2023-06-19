class Solution {
    public int largestAltitude(int[] gain) {

        int highestAltitude = 0;
        int actualAltitude = 0;

        for(int i = 0; i < gain.length; i++)
        {
            actualAltitude += gain[i];
            highestAltitude = Math.max(actualAltitude, highestAltitude); 
        }

        return highestAltitude;
    }
}
