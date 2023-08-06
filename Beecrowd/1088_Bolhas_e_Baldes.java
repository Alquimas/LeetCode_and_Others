import java.util.*;
public class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true)
        {
            int k = Integer.parseInt(sc.next());
            
            if(k == 0) break;
            
            int[] arr = new int[k];
            
            for(int i = 0; i < k; i++)
            {
                arr[i] = Integer.parseInt(sc.next()) - 1;
            }
            
            if(isOdd(arr))  System.out.println("Marcelo");
            else System.out.println("Carlos");
            
            sc.nextLine();
        }
    }
    
    static boolean isOdd(int[] a)
    {
        int size = a.length;
        
        boolean[] visited = new boolean[size];
        
        int totalSize = 0;
        int cycleSize = 0;
        
        for(int i = 0; i < a.length; i++)
        {
            int k = i;
            while(!visited[k])
            {
                cycleSize++;
                visited[k] = true;
                k = a[k];
            }
            totalSize += (cycleSize > 0) ? (cycleSize - 1) : 0;
            cycleSize = 0;
        }
        return (totalSize % 2 == 1);
    }
}
