class Solution {
    public int splitArray(int[] nums, int k) {
       int low=0;
       int high=0;
       for(int i:nums)
       {
        low=Math.max(i,low);
        high+=i;
       }
       int ans=low;
       while(low<=high)
       {
        int mid=low+(high-low)/2;
        if(possible(nums,k,mid))
        {
            ans=mid;
           high=mid-1; }
        else
        low=mid+1;
       }
return ans;
    }
    private boolean possible(int[]nums, int k, int mid)
    {
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]+sum>mid)
            {
                count++;
                sum=nums[i];

            }
            else
            {
                sum+=nums[i];
            }
        }
        return count<=k;
    }
}