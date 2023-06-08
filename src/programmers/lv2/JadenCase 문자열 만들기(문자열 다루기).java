import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split(" ");
        
        strArr = Arrays.stream(strArr)
            .map(n -> changeToJadenCase(n))
            .toArray(String[]::new);
        
        answer = String.join(" ", strArr);
        
        return answer;
    }
    
    public String changeToJadenCase(String n) {
        if(n.contains(" ")) {
            return " ";
        }
        return n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
    }
}
