class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indexes = new int[2];
        int left=0;
        int right = numbers.length -1;
        
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum<target){
                left++;
            }
            else if(sum>target){
                right--;
            }
            else{
                indexes[0]=left+1;
                indexes[1]=right+1;
                break;
            }
        }
        return indexes;
    }
}