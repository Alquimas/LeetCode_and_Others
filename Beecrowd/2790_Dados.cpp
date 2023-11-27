#include <bits/stdc++.h>
using namespace std;

int _min(int a, int b)
{
    return (a > b)*b + (a <= b)*a;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, a, res[6];

    cin >> n;

    for(int j = 0; j < 6; j++) 
    {
        res[j] = 0;
    }

    for(int i = 0; i < n; i++)
    {
        cin >> a;
        for(int j = 0; j < 6; j++)
        {
            if(j + 1 == a)
                continue;
            if(j + a == 6)
            {
                res[j] += 2;
                continue;
            }
            res[j] += 1;
        }
    }

    cout << _min(res[0],
            _min(res[1],
            _min(res[2],
            _min(res[3],
            _min(res[4],
                 res[5])
            )))) << "\n";

    return 0;
}
