# 解法一 动态规划解法 O(n^2)
思路：

**设d[i]表示以A[i]结尾的最长严格递增子序列的长度。**

当j < i 且 A[j] < A[i]时，说明d[j]对d[i]有贡献。d[i] = d[j]+1。


```cpp
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        const int N = nums.size();
        vector<int> d(N,1);
        int ans = 0;
        for(int i = 0;i<N;++i){
            for(int j=0;j<i;++j){
                if(nums[j] < nums[i]){//A[j] < A[i]
                    d[i] = max(d[i],d[j]+1);
                }
            }
            ans = max(ans,d[i]);
        }
        return ans;
    }
};
```


# 解法二 二分查找 O(nlogn)
思路:

设序列ans是一个最长上升子序列。

考虑元素x，
当ans为空 或 ans.tail < x时，序列能增长,x入ans。
否则，在ans中二分查找x下边界， 
如果没有找到x，序列能增长,x入ans。
如果找到x，最长上升序列发生变化，用x替换此处的值。

```cpp
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        const int N = nums.size();
        vector<int> ans;
        for(auto x : nums){
            if(ans.empty() || ans.back() < x){
                ans.push_back(x);
            }else{
                auto it = lower_bound(ans.begin(),ans.end(),x);
                if(it == ans.end()){
                    ans.push_back(x);
                }else{
                    *it = x;
                }
            }
        }


        return ans.size();
    }
};
```

# 解法三 二分查找 O(nlogn)
思路：

**设d[i]表示以A[i]结尾的最长严格递增子序列的长度。**
**设g[k]表示长度为k的上升子序列中最大元素的最小值。**

初始值：k >= 1,g[k]=正无穷。d[i] = 1.

考虑元素A[i]。
从g[1,...,N]中查找A[i]的下边界。设下标为k。
那么，g[k] = A[i]。
d[i] = k.

```cpp
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        const int N = nums.size();
        vector<int> d(N,1);
        vector<int> g(N+1,INT_MAX);
        int ans = 0;
        for(int i=0;i<N;++i){
            int k = lower_bound(g.begin()+1,g.end(),nums[i]) - g.begin();
            g[k] = nums[i];
            d[i] = k;
            ans = max(ans,d[i]);
        }
        return ans;
    }
};
```
