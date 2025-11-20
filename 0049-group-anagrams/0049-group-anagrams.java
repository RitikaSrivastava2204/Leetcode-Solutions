class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] forSort = str.toCharArray();
            Arrays.sort(forSort);
            String sorted = new String(forSort);
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }else{
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}