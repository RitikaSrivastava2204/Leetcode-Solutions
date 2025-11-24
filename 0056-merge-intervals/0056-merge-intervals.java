class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1,interval2) -> interval1[0]-interval2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            if(result.get(result.size()-1)[1] >= intervals[i][0]){
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],intervals[i][1]);
            }
            else{
                result.add(intervals[i]);
            }
        }
        int[][] finalResult = new int[result.size()][2];
        for(int i=0; i<finalResult.length; i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}