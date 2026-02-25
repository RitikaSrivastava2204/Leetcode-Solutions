class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for(int i =0; i<arr.length; i++){
            nums[i] = arr[i];
        }
        Arrays.sort(nums, (a,b)->{
            int abits = Integer.bitCount(a);
            int bbits = Integer.bitCount(b);
            if(abits == bbits){
                return a - b;
            }
            return abits - bbits;
        });
        for(int i=0; i<arr.length; i++){
            arr[i] = nums[i];
        }
        return arr;
    }
}