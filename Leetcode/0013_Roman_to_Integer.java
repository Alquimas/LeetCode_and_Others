class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int n = s.length();
        int num = map.get(s.charAt(n-1));
        int j = n-2;
        while(j > -1)
        {
            if(map.get(s.charAt(j)) >= map.get(s.charAt(j+1)))
            {
                num+=map.get(s.charAt(j));
            }
            else
            {
                num-=map.get(s.charAt(j));
            }
            j--;
        }
        return num;
    }
}
