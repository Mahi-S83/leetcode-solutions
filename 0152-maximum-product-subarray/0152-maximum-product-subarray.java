class Solution {
    public int maxProduct(int[] nums) {
       int maxprod=nums[0];
       int minprod=nums[0];
       int ans=nums[0];
       for(int i=1;i<nums.length;i++)
       {
        if(nums[i]<0)// swap is only because multiplying by a negative reverses the order of positive/negative values.
        {
            int temp=minprod;
            minprod=maxprod;
            maxprod=temp;
        }
        maxprod=Math.max(nums[i],maxprod*nums[i]);//either start a fresh subaray or extend previous one;
        minprod=Math.min(nums[i],minprod*nums[i]);
        ans=Math.max(ans,maxprod);
       }
       return ans;
    }
}