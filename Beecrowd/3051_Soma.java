import java.io.IOException;
import java.util.*;
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.next());
        int K = Integer.valueOf(sc.next());
        sc.nextLine();
        
        int[] nums = new int[N + 1];
        int sum = 0;
        long result = 0;
        
        for(int i = 0; i < N; i++)
        {
            sum += Integer.valueOf(sc.next());
            nums[i + 1] = sum;
            
            int m1 = BS1(nums, 0, i, nums[i + 1] - K);
            int m2 = BS2(nums, 0, i, nums[i + 1] - K);
            if(m1 + 1 > m2 - 1) continue;
            result += Math.abs(m1 - m2) - 1;
        }
        
        System.out.println(result);
        
        
    }

    public static int BS1(int[] nums, int start, int end, int target)
    {
    //retorna a posicao anterior a primeira ocorrencia do target
        int min = start;
        int max = end;
        
        if(nums[min] >= target) return -1;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (nums[mid] >= target)
            {
                max = mid - 1;
            }
            else
            {
                min = mid + 1;
            }
        }

        return max;
    }

    public static int BS2(int[] nums, int start, int end, int target)
    {
    //retorna a posicao seguinte a ultima ocorrencia do target
        int min = start;
        int max = end;
        
        if(nums[max] <= target) return max+1;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (nums[mid] <= target)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
        }
        return min;
    }
}
