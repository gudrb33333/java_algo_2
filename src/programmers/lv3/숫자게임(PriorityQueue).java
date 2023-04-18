package programmers.lv3;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> aQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<Integer>();
    
        for (int i = 0; i < A.length; i++) {
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }
        
        while (!bQueue.isEmpty()) {
            
            int a = aQueue.poll();
            
            while (!bQueue.isEmpty()) {
                if (bQueue.poll() <= a) {
                    continue;
                }
                
                answer += 1;
                break;
            }
            
        }
        
        return answer;
    }
}
