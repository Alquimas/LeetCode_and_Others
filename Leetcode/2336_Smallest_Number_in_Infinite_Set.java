class SmallestInfiniteSet {

int[] set = new int[1001];

    public SmallestInfiniteSet() 
    {
        for(int i = 0; i<1001; i++)
            set[i] = i+1;
    }
    
    public int popSmallest() 
    {
        int a;
        for(int i = 0; i<1001; i++)
            if(set[i] != 0)
            {
                a = set[i];
                set[i] = 0;
                return a;
            }
        return 0;
    }

    public void addBack(int num)
    {
        if(set[num-1] == num)
            return;
        else set[num-1] = num;
    }
    
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
