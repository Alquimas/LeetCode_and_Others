import java.util.*;
class Solution
{
    public int lastStoneWeight(int[] stones)
    {
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int weight: stones)
        {
            max_heap.add(weight);
        }
        while(max_heap.size() != 1 && !max_heap.isEmpty())
        {
            int y = max_heap.poll();
            int x = max_heap.poll();
            if(x != y) max_heap.add(y-x);
        }
        if(max_heap.size()==1) return max_heap.peek();
        return 0;
    }
}
