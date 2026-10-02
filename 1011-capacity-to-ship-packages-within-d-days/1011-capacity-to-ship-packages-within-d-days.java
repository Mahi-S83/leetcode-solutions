class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int n=weights.length;
       int low=0;
       int high=0;
       for(int i:weights)
      { low=Math.max(low,i);
        high+=i;}
        int ans=high;
       while(low<=high)
       {
        int mid=low+(high-low)/2;
        if(possible(n,weights,days,mid))
        {
            ans=mid;
            high=mid-1;
        }
        else
        low=mid+1;
       } 
       return ans;
    }
    private boolean possible(int n, int[] weights, int days, int mid)
    {
       int countdays=1;
       int sum=0;
       for(int i:weights)
       {
        if(sum+i<=mid)
        {
            sum+=i;
        }
        else
        {
            countdays++;
            sum=i;
        }

        
       }
       return countdays<=days;
    }
}
// 1. high += weights[i] was wrong because i is the weight itself, not an index.
//    Use high += i.

// 2. low should be maximum weight, not 1, because a package cannot be split.

// 3. ans was declared inside the if block, so it was not accessible outside.
//    Declare it before the while loop.

// 4. When possible(mid) is true, search left (high = mid - 1)
//    because we need the minimum capacity.

// 5. possible() parameter should be int[] weights, not int weights.

// 6. countdays should start from 1 because shipping starts on day 1.

// 7. When a package doesn't fit, increment countdays and set sum = i.
//    The current package must be loaded on the new day.

// 8. Don't reset sum and increment the day when sum == mid.
//    Start a new day only when the next package exceeds capacity.

// 9. Check countdays <= days, because shipping within the given days is valid.