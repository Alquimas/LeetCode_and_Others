import java.util.*;
public class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true)
        {
            int k = Integer.parseInt(sc.next());
            sc.nextLine();
            
            if(k == 0) break;
            if(k == 1)
            {
                System.out.println("Discarded cards: \nRemaining card: 1");
                continue;
            }
            
            Deque<Integer> myQueue = new ArrayDeque<>();
            String s = new String("Discarded cards:");
            for(int i = 1; i <= k; i++)
                myQueue.addLast(i);

            while(myQueue.size() > 2)
            {
                s += " " + myQueue.pollFirst() + ",";
                myQueue.addLast(myQueue.pollFirst());
            }
            s += " " + myQueue.pollFirst();
            myQueue.addLast(myQueue.pollFirst());
            System.out.println(s + "\nRemaining card: " + myQueue.poll());
            
        }
    }
}
