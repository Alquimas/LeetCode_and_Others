#include <stdio.h>

int main()
{
    int k;
    
    scanf("%d", &k);
    
    for(int i = 0; i < k; i++)
    {
        int m;
        
        scanf("%d", &m);
        
        int z = 1;
        
        for(int j = 0; j < m-1; j++)
        {
            printf("%d ", z);
            z += 3;
        }
        printf("%d\n", z);
    }
}
