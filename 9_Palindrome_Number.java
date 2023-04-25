class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        char[] string = Integer.toString(x).toCharArray();
        for(int i = 0; i<string.length/2; i++)
            if(string[i] != string[string.length-i-1]) return false;
        return true;
    }
}
