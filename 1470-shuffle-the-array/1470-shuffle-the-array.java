class Solution {
    public int[] shuffle(int[] nums, int n) {
       int[] ans = new int[nums.length];
       int i = 0;
       int j = nums.length/2;
       int k = 0;
       while(j<ans.length){
        ans[k] = nums[i];
        ans[k+1] = nums[j];
        i++;
        j++;
        k +=2;
       } 
       return ans;
    }
}