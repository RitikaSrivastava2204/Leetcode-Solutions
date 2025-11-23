class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length < 3){
            for(int num:nums){
                if(!result.contains(num)){
                    result.add(num);
                }
            }
        }
        else{
            int count=1;
        int i = 0;
        Arrays.sort(nums);
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]){
                count++;
            }
            else{
                count = 1;
            }
            if(count>nums.length/3){
                if(!result.contains(nums[i])){
                    result.add(nums[i]);
                }
                if(result.size()==2) break;
            }
            i++;
        }
        }
        return result;
    }
}