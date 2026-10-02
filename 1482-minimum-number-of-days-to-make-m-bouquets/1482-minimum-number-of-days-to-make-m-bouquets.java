class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
      int low=1;
      int high=0;
      int z=bloomDay.length;
      
      for(int n:bloomDay)
      {
        high=Math.max(n,high);
      }
      if ((long) m * k > bloomDay.length) {
            return -1;
        }
      int day=0;  
      int ans=-1;
      while(low<=high)
      {
        int mid=low+(high-low)/2;
        if(possible(mid,bloomDay,m,k))
        {
            ans=mid;//candidate day
            high=mid-1;
        }
        else
        low=mid+1;

      }
      return ans;
    }
    private boolean possible(int day,int[] bloomDays,int m, int k)
    {
        int nofb=0;
        int count=0;
        int n=bloomDays.length;
        for(int i=0;i<n;i++)
        {
            if(bloomDays[i]<=day)
            {
                count+=1;
                if(count>=k)
                {
                    nofb++;
                count = 0;
                }

            }
            else
            {
                count=0;
            }
        }
        
        return nofb>=m;
    }
}