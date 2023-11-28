#include <bits/stdc++.h>
using namespace std;

const int MAX = 200001;

int Esq[MAX], Dir[MAX];

char L[MAX];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;

    cin >> n;

    int ef = n;

    int e, d, next;

    char l;

    while(n--)
    {
        cin >> e >> l >> d;
        if(e == 0)
        {
            cout << l;
            next = d;
        }
        Esq[e] = e;
        Dir[e] = d;
        L[e] = l;
    }
    for(int i = 1; i < ef; i++)
    {
        cout << L[next];
        next = Dir[next];
    }

    return 0;
}
