import java.io.IOException;
import java.util.*;
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        while(sc.hasNext())
        {
            int N = Integer.valueOf(sc.nextLine());
    
            int[] nums = new int[N];
    
            for(int i = 0; i < N; i++)
            {
                nums[i] = Integer.valueOf(sc.nextLine());
            }
        
            Arrays.sort(nums);
        
            for(int i = 0; i < N; i++)
            {
                if(nums[i] < 1000)
                    System.out.print("0");
                if(nums[i] < 100)
                    System.out.print("0");
                if(nums[i] < 10)
                    System.out.print("0");
                System.out.println(nums[i]);
            }
        }
    }
}
