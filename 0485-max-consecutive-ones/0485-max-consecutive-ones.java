class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i =0;
        int sum = 0;
        int maxSum = 0;
        
        while(i<nums.length){
            if(nums[i]==1){
                sum++;
                maxSum = Math.max(sum,maxSum);
            }
            else{
                sum=0;
            }
            i++;
        }
        return maxSum;
    }
}