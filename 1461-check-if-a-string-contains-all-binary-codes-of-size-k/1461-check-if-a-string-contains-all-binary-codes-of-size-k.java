class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        HashSet<String> set = new HashSet<>();
        int i = k;
        while(i<=s.length()){
            String code = s.substring(i-k,i);
            set.add(code);
            i++;
        }
        if(set.size()== (int)Math.pow(2,k)) return true;
        else return false;

    }
}