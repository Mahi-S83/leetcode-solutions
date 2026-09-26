class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //since it is asking for distint
        int n=nums.length;
        Arrays.sort(nums);
     List<List<Integer>> ans=new ArrayList<>();

     for(int i=0;i<n-3;i++)
     {
         if (i > 0 && nums[i] == nums[i - 1])
                continue;

            long newtar = (long)target - nums[i];

        for(int j=i+1;j<n-2;j++)
        {
             // Skip duplicate second number
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

            int fix=nums[j];
            int left=j+1;
            int right=n-1;
            while(left<right)
            {
                long sum=(long)fix+nums[left]+nums[right];
                if(sum==newtar)
                {
                    ans.add(Arrays.asList(nums[i],fix,nums[left],nums[right]));
                    left++;
                    right--;
                    //removing duplicates
                    while(left<right && nums[left]==nums[left-1])
                    left++;
                    while(left<right && nums[right]==nums[right+1])
                    right--;
                }
                else if(sum<newtar)
                left++;
                else
                right--;
            }
        }
     }return ans;
    }
   
}
// 4SUM MISTAKES TO REMEMBER:
//
// 1. j starts from i + 1, NOT i
//
// 2. Skip duplicate i:
//    if (i > 0 && nums[i] == nums[i - 1])
//
// 3. Skip duplicate j:
//    if (j > i + 1 && nums[j] == nums[j - 1])
//
// 4. Answer needs 4 numbers:
//    nums[i], nums[j], nums[left], nums[right]
//
// 5. After left++, skip duplicates using:
//    nums[left] == nums[left - 1]
//
// 6. After right--, skip duplicates using:
//    nums[right] == nums[right + 1]
//
// 7. sum < target → left++
//
// 8. sum > target → right--
//    NEVER right++
//
// 9. Overall pattern:
//    Fix i → Fix j → Two pointers