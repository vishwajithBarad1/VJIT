class Solution {
    public int thirdMax(int[] nums) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return (nums[0]>nums[1])?nums[0]:nums[1];
        }
        boolean minInc=false;
        int count=0;
        for(int val:nums){
            if(val==Integer.MIN_VALUE && !minInc){
                minInc=true;
                count++;
            }
            if(val==max1 || val==max2 || val==max3){
                continue;
            }
            if(val>max1) {
                max3 = max2;
                max2 = max1;
                max1 = val;
                count++;
            }else if(val>max2){
                max3=max2;
                max2=val;
                count++;
            }else if(val>max3){
                max3=val;
                count++;
            }
        }
        if(count<3){
            return max1;
        }else{
            return max3;
        }
    }
}
