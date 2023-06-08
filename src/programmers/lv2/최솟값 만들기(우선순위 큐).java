import java.util.*;

class Solution
{
    private PriorityQueue<Integer> minQ = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    
    public int solution(int []A, int []B)
    {
        int answer = 0;
    
        for (int i = 0; i < A.length; i++) {
            minQ.add(A[i]);
            maxQ.add(B[i]);
        }    
    
        while (!minQ.isEmpty()) {
            int result = minQ.poll() * maxQ.poll();
            answer += result;
        }
        
        return answer;
    }
}
