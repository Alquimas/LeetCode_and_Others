#include <stdio.h>

int main()
{
    int t;
    
    scanf("%d", &t);
    
    for(int i = 0; i < t; i++)
    {
        long long n, k, x;
        
        scanf("%lld %lld %lld", &n, &k, &x);
        
        if(n < k)
        {
            printf("NO\n");
            continue;
        }
        
        long long min = k * (k + 1) / 2;
        
        long long max =(n * (n + 1) / 2) - ((n - k) * (n - k + 1) / 2);
        
        if(min <= x && max >= x) printf("YES\n");
        else printf("NO\n");
    }
}
