class Solution {
    public void sortColors(int[] nums) {
      int count0=0;
      int count1=0;
      int l=nums.length;
      for(int n:nums)
      {
        if(n==0)
        count0++;
        if(n==1)
        count1++;
      } 
      int count2=l-(count0+count1);
     Arrays.fill(nums,0,count0,0);
     Arrays.fill(nums,count0,count1+count0,1);
     Arrays.fill(nums,count1+count0,l,2);
    }
}