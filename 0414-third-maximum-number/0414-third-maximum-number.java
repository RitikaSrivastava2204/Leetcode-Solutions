class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int ele : nums){
            if(ele>first){
                third = second;
                second = first;
                first = ele;
            }
            else if(ele < first && ele > second){
                third = second;
                second = ele;
            }
            else if(ele < second && ele > third){
                third = ele;
            }
        }





        return third == Long.MIN_VALUE? (int) first : (int) third;
    }
}