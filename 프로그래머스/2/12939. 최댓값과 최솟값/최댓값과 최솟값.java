import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] ans = s.split(" ");
        int max = Integer.parseInt(ans[0]);
        int min = Integer.parseInt(ans[0]);
        
        for(int i=0;i<ans.length;i++){
            max = Math.max(max, Integer.parseInt(ans[i]));
            min = Math.min(min, Integer.parseInt(ans[i]));
        }
        
        String answer = min +" "+ max;
        return answer;
    }
}