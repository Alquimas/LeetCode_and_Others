class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        int n4 = 0;
    
       for(int i = 2; i < n; i++){
          n4 = n1 + n2 + n3;
          n1 = n2;
          n2 = n3;
          n3 = n4;
       }
       return n4;
    }
}
