import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        outerloop:
        while(true)
        {
            int k = Integer.parseInt(sc.nextLine());
            
            if(k == 0) return;
            
            int[] myArr = new int[k];
            
            for(int i = 0; i < k; i++)
            {
                int a = Integer.parseInt(sc.next());
                int b = Integer.parseInt(sc.next());
                sc.nextLine();
                
                if((i + b) > -1 && (i + b) < k && myArr[i + b] == 0)
                {
                    myArr[i + b] = a;
                }
                else
                {
                    for(i = i + 1; i < k; ++i)
                        sc.nextLine();
                    System.out.println("-1");
                    continue outerloop;
                }
            }
            for(int i = 0; i < k - 1; ++i)
            {
                System.out.print(myArr[i] + " ");
            }
            System.out.println(myArr[k - 1]);
        }
    }
}
