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
/*
REVISION NOTES / MISTAKES:

1. index = -1, not 0
   → index 0 can be a valid pivot.
   → -1 means pivot was not found.

2. If index == -1:
   → reverse the whole array AND return.
   → Otherwise code will continue unnecessarily.

3. To find the next element:
   → Need nums[j] > nums[index].
   → My mindiff approach could select a smaller number.
   → Since suffix is decreasing, search from RIGHT.

4. reverse():
   → Use two pointers: i = start, j = end - 1.
   → Don't write: end - 1 / 2 because of integer division/order.

5. Use nums, not arr.
*/