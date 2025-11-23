class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> nums = new ArrayList<>();
       generate(1, numRows, nums, result);
       return result;
    }
    public void generate(int row, int numRows,List<Integer> nums,List<List<Integer>> result){
        if(row>numRows){
            return;
        }
        List<Integer> nextNums = new ArrayList<>();
        nextNums.add(1);
        if(nextNums.size()!=row){
            if(row<3){
            nextNums.add(1);
            }
            for(int i=0; i<nums.size()-1; i++){
               int sum = nums.get(i)+nums.get(i+1);
               nextNums.add(sum);
            }
        }
        if(nextNums.size()!=row){
            nextNums.add(1);
        }
        result.add(nextNums);
        generate(row+1, numRows, nextNums, result);
    }
}