#include<iostream>    
using namespace std;

int BinarySearch(int nums[], int target, int size);

int main() 
{
        
    int N, M;
        
    cin >> N;
    cin >> M;
        
    int rank[N-1];
    for(int i = 0; i < N - 1; i++)
    {
        cin >> rank[i];
    }
        
    int points[N];
    for(int i = 0; i < N; i++)
    {
        cin >> points[i];
    }
        
    int k;
        
    for(int i = 0; i < M; i++)
    {
        cin >> k;
        cout << points[BinarySearch(rank, k, N-1) + 1];
        cout << " ";
    }
    
    return 0;
}

int BinarySearch(int nums[], int target, int size)
{
    //usa o resultado disso +1
    int min = 0;
    int max = size-1;
        
    if(nums[min] > target) return -1;
        
    while (min <= max) 
    {
        int mid = (min + max)/2;

        if (nums[mid] > target)
        {
            max = mid - 1;
        }
        else if(nums[mid] < target)
        {
            min = mid + 1;
        }
        else
        {
            return mid;
        }
    }
    return max;
}
