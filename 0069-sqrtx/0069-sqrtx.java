class Solution {
    public int mySqrt(int target) {
        int low=0;
        int high=target;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            long sq=(long)mid*mid;
            if(sq==target)
            return mid;
            else if(sq<target)//it can be a candidate
            low=mid+1;
            else
            high=mid-1;


        }
        return high;
    }
}