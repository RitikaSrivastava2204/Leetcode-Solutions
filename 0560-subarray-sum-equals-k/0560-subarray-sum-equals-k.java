class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length ==1){
            if(nums[0]==k) return 1;
            return 0;
        }
        int count = 0;
        int prefixsum = 0;
        for(int i=0; i<nums.length; i++){
            prefixsum = prefixsum + nums[i];
            nums[i] = prefixsum;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==k) count++;
            for(int j=0; j<i; j++){
                if(nums[i]-nums[j]==k) count++;
            }
        }
        return count;
    }
}