class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] hasAppeared = new boolean[nums.length+1];
        for(int num : nums){
            hasAppeared[num] = true;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=1; i<hasAppeared.length; i++){
            if(!hasAppeared[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}