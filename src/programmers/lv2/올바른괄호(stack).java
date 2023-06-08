import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<Character> stk = new Stack<Character>();
		
		for(char x : s.toCharArray()) {
			if(stk.size() == 0) {stk.push(x); continue;}
			
			if(stk.peek() == '(') {
				if(x == ')') stk.pop();
				else stk.push(x);
			}else {
				stk.push(x);
			}
		}
		
		if(stk.size()>0) answer = false;
        return answer;
    }
}
