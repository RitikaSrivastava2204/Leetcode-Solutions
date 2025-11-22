class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1]) break;
            else i--;
        }
        if(i==-1){
            Arrays.sort(nums);
            
        }
        else{
            int breakpoint = i;
            i = i+1;
            int smallestGreater = Integer.MAX_VALUE;
            int smallestIndex = 0;
            while(i<nums.length){
                if(nums[i]>nums[breakpoint] && nums[i]<smallestGreater){
                    smallestGreater = nums[i];
                    smallestIndex = i;
                }
                i++;
            }
            nums[smallestIndex] = nums[breakpoint];
            nums[breakpoint] = smallestGreater;
            Arrays.sort(nums,breakpoint+1, nums.length);
            
        }
        
    }
}