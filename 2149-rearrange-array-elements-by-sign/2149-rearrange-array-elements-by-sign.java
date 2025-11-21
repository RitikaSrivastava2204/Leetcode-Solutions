class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] posNums = new int[nums.length /2];
        int[] negNums = new int[nums.length / 2];
        int i = 0; int j = 0;
        for(int num : nums){
            if(num>0){
                posNums[i++] = num;
            }
            else{
                negNums[j++] = num;
            }
        }
        i=0;
        int k = 0;
        while(k<=nums.length-2){
            nums[k] = posNums[i];
            nums[k+1] = negNums[i];
            i++;
            k=k+2;
        }
        return nums;
    }
}