//n
import java.util.*;
public class imperial
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.valueOf(sc.nextLine());
		
		if(N == 1 || N == 2)
		{
			System.out.println(N);
			return;
		}
		
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			nums[i] = Integer.valueOf(sc.nextLine());
		}
		
		
		int max = 2;
		int act;
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i + 1; j < N; j++)
			{
				if(nums[i] == nums[j]) continue;
				
				int counter = 2;
				act = nums[i];
				
				for(int k = j + 1; k < N; k++)
				{
					if(act == nums[k])
					{
						counter++;
						act = (nums[i] + nums[j]) - act;
					}
				}
				max = Math.max(counter, max);
			}
		}
		System.out.println(max);
	}
}
