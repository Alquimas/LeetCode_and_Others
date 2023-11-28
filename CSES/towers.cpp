#include <bits/stdc++.h>
using namespace std;

int lengthOfLIS(vector<int>& nums)
{
    int n = nums.size();
    vector<int> ans;

    ans.push_back(nums[0]);

    for (int i = 1; i < n; i++)
    {
        if (nums[i] >= ans.back())
        {
            ans.push_back(nums[i]);
        }
        else
        {
            int low = upper_bound(ans.begin(), ans.end(), nums[i]) - ans.begin();
            ans[low] = nums[i];
        }
    }

    return ans.size();
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;

    cin >> n;

    vector<int> ans;

    while(n--)
    {
        cin >> k;
        ans.push_back(k);
    }

    cout << lengthOfLIS(ans);

    return 0;
}
