class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(high>=low){
            int mid = low + (high-low/2);
            if(nums[mid]==target){
                ans = mid;
                break;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        if (ans==-1){
            ans = low;
        }
    return ans;    
    }
    
}