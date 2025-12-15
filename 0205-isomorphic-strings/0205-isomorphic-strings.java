class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        boolean result = true;
        if(s.length()==t.length()){
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    if(t.charAt(i) == map.get(c)){
                        result = true;
                    }
                    else{
                        result = false;
                        break;
                    }
                }
                else{
                    if(map.containsValue(t.charAt(i))){
                        result = false;
                        break;
                    }
                    else{
                        map.put(s.charAt(i),t.charAt(i));
                    }
                    
                }
            }
        }
        else{
            result = false;
        }
        return result;
    }
}