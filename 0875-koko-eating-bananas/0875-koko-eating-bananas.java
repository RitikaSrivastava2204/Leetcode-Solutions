class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int minSpeed = 0;
       int low = 1;
       int high = maxPile(piles);
       while(low<=high){
        int mid = low + (high - low)/2;
        if(check(mid, h, piles)){
            minSpeed = mid;
            high = mid-1;
        }
        else{
            low = mid+1;
        }
       }
       return minSpeed;
    }
    public boolean check(int speed, int hoursLimit, int[] piles){
        long reqHours = 0;
        for(int pile : piles){
            reqHours += pile/speed;
            if(pile%speed != 0) reqHours++;
        }
        if(reqHours > hoursLimit) return false;
        return true;
    }
    public int maxPile(int[] piles){
        int max = piles[0];
        for(int pile : piles){
            if (pile>max) max = pile;
        }
        return max;
    }
}