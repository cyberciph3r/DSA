class Solution {
    
    static List<String> res;
    static String ans;
    
    Solution(){
        res = new ArrayList<>();
        ans = "";
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        Set<String> hs = new HashSet();
        
        for(String word : wordDict){
            hs.add(word);
        }
        
        f(s,0,hs);
        
        return res;
    }
    
    public static boolean f(String s, int index, Set<String> hs){
        
        if(index >= s.length()){
            return true;
        }
        
        String temp = ans;
        for(int i = index ; i < s.length() ; i++){
            ans += s.substring(index,i+1)+" ";
            if(hs.contains(s.substring(index,i+1)) && f(s,i+1,hs)){
                res.add(ans.substring(0,ans.length()-1));
            }
            ans = temp;
        }
        
        return false;
    }
}