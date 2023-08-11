import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
    
            sc.nextLine();
    
            Map<Integer, ArrayList<Integer>> list = new HashMap<>();
    
            for(int i = 0; i < a; i++)
            {
                int k = Integer.parseInt(sc.next());
                if(list.containsKey(k))
                {
                    list.get(k).add(i+1);
                }
                else
                {
                    list.put(k, new ArrayList());
                    list.get(k).add(i+1);
                }
            }
    
            sc.nextLine();
    
            for(int i = 0; i < b; i++)
            {
                int m = Integer.parseInt(sc.next());
                int n = Integer.parseInt(sc.next());
                sc.nextLine();
                if(list.containsKey(n))
                {
                    if(list.get(n).size() < m)
                    {
                        System.out.println("0");
                    }
                    else
                    {
                        System.out.println(list.get(n).get(m-1));
                    }
                }
                else
                {
                    System.out.println("0");
                }
            }
        }
    }
}
