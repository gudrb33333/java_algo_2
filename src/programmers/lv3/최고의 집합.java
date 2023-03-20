package programmers.lv3;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {    
        if (n > s) {
            return new int[]{-1};
        }
        
        int baseNum = s/n;
        int[] answer = new int[n];
        Arrays.fill(answer, baseNum);
        
        int index = n - 1;
        for (int i = 0; i < s - (baseNum * n); i++) {
            answer[index] += 1;
            
            index -= 1;
            if (index == -1) {
                index = n - 1;
            }
        } 
        
        return answer;
    }
}
