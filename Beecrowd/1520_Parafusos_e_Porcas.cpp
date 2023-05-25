#include<iostream>    
#include<algorithm>
using namespace std;

    int BS1(int nums[], int start, int end, int target)
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
    
    int bs2(int nums[], int start, int end, int target)
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

int main() 
{
    int N;
  while(cin >> N)
  {
            
            
    int rack[10001];
    for(int i = 0; i < 10001; i++) rack[i] = 0;
            
    int j = 0;
            
    for(int i = 0; i < N; i++)
    {
      int a;
      int b; 
      cin >> a;
      cin >> b;
                
      for(int k = a; k < b + 1; k++)
      {
        rack[j] = k;
        j++;
      }
    }
            
      int M;
      cin >> M;
            
      std::sort(rack, rack + j);
            
      int m1;
      int m2;
            
      m1 = BS1(rack, 0, j - 1, M);
            
      m2 = BS2(rack, 0, j - 1, M);
            
      if(m1 + 1 > m2 - 1)
      {
      	cout << M;
        cout << " not found\n";
        continue;
      }
      else
      {
      	cout << M;
        cout << " found from "; 
        cout << (m1 + 1);
        cout << " to "; 
        cout << (m2 - 1);
        cout << "\n";
      }
    }
    return 0;
  }
