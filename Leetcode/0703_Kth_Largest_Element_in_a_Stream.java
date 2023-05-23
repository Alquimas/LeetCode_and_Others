class KthLargest {
    public int k;
    public PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++)
        {
            this.myQueue.offer(nums[i]);
        }

        while(this.myQueue.size() > k)
        {
            this.myQueue.poll();
        }
    }
    
    public int add(int val) {
        this.myQueue.offer(val);
        if(this.myQueue.size() > this.k)
        {  
            this.myQueue.poll();
        }

        return this.myQueue.peek();
    }
}
