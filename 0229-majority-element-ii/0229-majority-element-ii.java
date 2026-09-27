class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans= new ArrayList<>();
        int n=nums.length;
        int targ=n/3;

        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>targ)
            ans.add(entry.getKey());
        }
        return ans;
    }

}
