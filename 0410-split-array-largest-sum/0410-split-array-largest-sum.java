class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE; // highest value in array;
        int high = 0; // sum of whole array
        int minimisedLargestSum = 0;
        for(int num : nums){
            high += num;
            if(num>low) low = num;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(check(nums, k, mid)){
                minimisedLargestSum = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return minimisedLargestSum;
    }
    public boolean check(int[] nums, int k, int minLargestSum){
        int reqSplits = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num > minLargestSum){
                reqSplits++;
                sum = 0;
            }
            sum += num;
        }
        if(reqSplits <= k) return true;
        return false;
    }
}