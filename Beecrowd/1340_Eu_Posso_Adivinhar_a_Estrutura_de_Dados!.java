import java.util.*;

public class Main {
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext())
        {
            int n = Integer.valueOf(sc.nextLine());
          
            Stack<Integer> myStack = new Stack<>();
          
            Queue<Integer> myQueue = new LinkedList<>();
            
            Comparator<Integer> comparator = new nComp();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);
            
            //variaveis de controle
            boolean stk = true;
            boolean que = true;
            boolean hep = true;
            
            for(int i = 0; i < n; i++)
            {
                int a = Integer.valueOf(sc.next());
                int b = Integer.valueOf(sc.next());
                sc.nextLine();
                
                if(a == 1)
                {
                    if(stk) myStack.add(b);
                    if(que) myQueue.offer(b);
                    if(hep) maxHeap.offer(b);
                }
                else
                {
                    if(stk)
                        if(myStack.empty())
                        {
                            stk = false;
                        }
                        else
                        {
                            stk = (myStack.pop() == b);
                        }
                    if(que)
                        if(myQueue.peek() == null)
                        {
                            que = false;
                        }
                        else
                        {
                            que = (myQueue.poll() == b);
                        }
                    if(hep)
                        if(hep && maxHeap.peek() == null)
                        {
                            hep = false;
                        }
                        else
                        {
                            hep = (maxHeap.poll() == b);
                        }
                }
            }
            if(!(stk || que || hep))
            {
                System.out.println("impossible");
                continue;
            }
            if((stk && que) || (stk && hep) || (que && hep))
            {
                System.out.println("not sure");
                continue;
            }
            if(stk)
            {
                System.out.println("stack");
                continue;
            }
            if(que)
            {
                System.out.println("queue");
                continue;
            }
            if(hep)
            {
                System.out.println("priority queue");
                continue;
            }
        }
    }
    static class nComp implements Comparator<Integer> 
    {
        @Override
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }
}
