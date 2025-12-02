class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int minCapacity = 0;
        for(int weight : weights){
            high += weight;
            if(weight>low) low = weight;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(check(mid, days, weights)){
                minCapacity = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return minCapacity;
    }
    public boolean check(int capacity, int daysLimit, int[] weights){
        int reqDays = 1;
        int sum = 0;
        for(int weight : weights){
            if(sum + weight > capacity){
                reqDays++;
                sum = 0;
            }
            sum += weight;           
        }
        if(reqDays > daysLimit) return false;
        return true;
    }
}