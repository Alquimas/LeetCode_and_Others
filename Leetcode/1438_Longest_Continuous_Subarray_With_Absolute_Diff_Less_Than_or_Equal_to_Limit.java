class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        Comparator<Integer> comparator = new nComp();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.offer(nums[0]);
        minHeap.offer(nums[0]);

        int total = 1;

        int secondPointer = 0;

        for(int i = 1; i < nums.length; i++)
        {
            maxHeap.offer(nums[i]);
            minHeap.offer(nums[i]);

            if(maxHeap.peek() - minHeap.peek() <= limit)
            {
                total = Math.max(total, i - secondPointer + 1);
            }
            else
            {
                while(maxHeap.peek() - minHeap.peek() > limit)
                {
                    maxHeap.remove(nums[secondPointer]);
                    minHeap.remove(nums[secondPointer]);

                    secondPointer++;
                }
                total = Math.max(total, i - secondPointer + 1);
            }
        }

        return total;
    }
}
class nComp implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
        return y - x;
    }
}
