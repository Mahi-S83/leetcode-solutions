class Solution {
    public int[] rearrangeArray(int[] nums) {
      ArrayList<Integer> pos=new ArrayList<>();
      ArrayList<Integer> neg=new ArrayList<>();
      for(int i=0;i<nums.length;i++)
      {
        if(nums[i]<0)
        neg.add(nums[i]);
        else
        pos.add(nums[i]);
      }
    
        int[] ans = new int[nums.length];

        int index = 0;

        for (int i = 0; i < pos.size(); i++) {
            ans[index] = pos.get(i);
            index++;

            ans[index] = neg.get(i);
            index++;
        }

        return ans;
    }
  
}