class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }
    public boolean isHappy(int n, HashSet<Integer> set){
        
        int sum = 0;
        while(n>0){
            int last = n%10;
            n = n/10;
            sum += last*last;
        }
        if(sum==1) return true;
        if(set.contains(sum)) return false;
        set.add(sum);
        return isHappy(sum,set);
    }
}