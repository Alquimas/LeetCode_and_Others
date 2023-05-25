#include<iostream>    
#include<algorithm>
using namespace std;

bool bs(int nums[], int target, int N)
{
	int max = N-1, min = 0, mid;
        while(min <= max)
        {
            mid = (max + min)/2;
            if(nums[mid] < target)
            {
                min = mid+1;
            }
            else if(nums[mid] > target)
            {
                max = mid-1;
            }
            else
            {
                return true;
            }
        }
        return false;
}

int main() {
	int N;
	cin >> N;
	
	int nums[N];
	
	for(int i = 0; i < N; i++)
	{
		cin >> nums[i];
	}
	std::sort(nums, nums + N);
	
	int k;
	
	while(cin >> k)
	{
		if(bs(nums, k, N))
		{
			cout << "sim\n";
		}
		else
		{
			cout << "nao\n";
		}
	}
	
	return 0;
}
