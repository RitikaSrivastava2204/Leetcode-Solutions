class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i<nums.length-3; i++){
            for(int j = i+1; j<nums.length-2; j++){
                int left = j+1;
                int right = nums.length-1;

                while(left<right){
                   long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        Collections.sort(triplet);
                        set.add(triplet);
                        left++;
                        right--;
                    }
                    else if(sum<target){
                    left++;
                    }
                    else{
                    right--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}