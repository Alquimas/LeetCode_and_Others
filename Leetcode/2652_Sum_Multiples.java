class Solution {
    public int sumOfMultiples(int n) 
    {
        return sum(n, 3) + sum(n, 5) + sum(n, 7) - sum(n, 3*5) - sum(n, 3*7) - sum(n, 5*7) + sum(n, 3*5*7);     
    }
    static int sum(int n, int k)
    {
        return k*(n/k)*(n/k + 1)/2;
    }
}
