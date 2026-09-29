class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        if(nums.length==0)
        return 0;
        int maxL=0;
        for(int a:nums)
        {
            set.add(a);
        }
        for(int num:set)
        {
            
        
           if(!set.contains(num-1))

           { int count=1;
            while(set.contains(num+1))
           {
            num++;
            count++;
           }maxL=Math.max(maxL,count);
           }
           
        }
     return maxL;
    }
}