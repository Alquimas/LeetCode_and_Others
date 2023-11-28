//noic prefix sum solution
#include <bits/stdc++.h>
using namespace std;

long long prefix[10001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, n, u, q;

    cin >> t;

    while(t--)
    {
        cin >> n >> u;
        for(int i = 0; i <= n; i++) prefix[i] = 0;

        while(u--)
        {
            int l, r;
            int x;

            cin >> l >> r >> x;

            prefix[l] += x;
            prefix[r + 1] -= x;
        }

        for(int i = 1; i < n; i++) prefix[i] += prefix[i - 1];

        cin >> q;

        while(q--)
        {
            int b;
            cin >> b;
            cout << prefix[b] << "\n";
        }
    }

    return 0;
}
