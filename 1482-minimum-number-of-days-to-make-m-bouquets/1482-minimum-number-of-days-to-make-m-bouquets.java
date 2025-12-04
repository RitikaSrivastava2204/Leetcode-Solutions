class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int days = -1;
        for(int day : bloomDay){
            if(day > high) high = day;
            if(day < low) low = day;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canMakeBouqets(bloomDay,m,k,mid)){
                days = mid;
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return days;
    }
    public boolean canMakeBouqets(int[] bloomDay, int m, int k, int currDay){
        int bouqets = 0;
        int flowers = 0;
        for(int day : bloomDay){
            
            if(day<=currDay){
                flowers++;
            }
            else{
                flowers = 0;
            }
            if(flowers == k){
                bouqets++;
                flowers = 0;
            }
        }
        if(bouqets >= m) return true;
        return false;
    }
}