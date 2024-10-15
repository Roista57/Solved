import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] ans = s.split(" ");
        
        Queue<MinNumber> minQueue = new PriorityQueue<>();
        for(int i=0;i<ans.length;i++){
            minQueue.offer(new MinNumber(Integer.parseInt(ans[i])));
        }
        
        Queue<MaxNumber> maxQueue = new PriorityQueue<>();
        for(int i=0;i<ans.length;i++){
            maxQueue.offer(new MaxNumber(Integer.parseInt(ans[i])));
        }
        
        String answer = maxQueue.peek().num +" "+ minQueue.peek().num;
        return answer;
    }
}

class MinNumber implements Comparable<MinNumber>{
    int num;
    
    public MinNumber(int num){
        this.num = num;
    }
    
    @Override
    public int compareTo(MinNumber o){
        return o.num - num;
    }
}

class MaxNumber implements Comparable<MaxNumber>{
    int num;
    public MaxNumber(int num){
        this.num = num;
    }
    
    @Override
    public int compareTo(MaxNumber o){
        return num - o.num;
    }
}