class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--)//run loop from right to left
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;

            }
        }
        if(index==-1)
        {reverse(0,n,nums);
        return;}
        int end = n - 1;

while (nums[end] <= nums[index]) {
    end--;
}
        //swap those two number
        int temp=nums[index];
        nums[index]=nums[end];
        nums[end]=temp;
        reverse(index+1,n,nums);
    }
    private static void reverse(int start, int end, int[]nums)
    {
           int j = end - 1;

        for (int i = start; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}