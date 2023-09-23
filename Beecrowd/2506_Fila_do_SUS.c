#include <stdio.h>
//Scanner eu te odeio
int main() {
 
    int i, counter;
    int k, a, b, c, hora;
 
    while(scanf("%d", &k) != EOF)
    {
        counter = 0;
        int nextAttend = 420;
 
        for(i = 0; i < k; i++)
        {
            scanf("%d %d %d", &a, &b, &c);
 
            hora = 60*a + b;
 
            while(nextAttend < hora)
                nextAttend += 30;
 
            if(nextAttend - hora > c)
                counter++;
 
            nextAttend += 30;
        }
 
        printf("%d\n", counter);
    }
    return 0;
}
