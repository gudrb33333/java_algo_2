package programmers.lv3;

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String code = operation.split(" ")[0];
            int value = Integer.parseInt(operation.split(" ")[1]);

            if (code.equals("I")) {
                minQ.add(value);
                maxQ.add(value);
            } else if (code.equals("D") && !minQ.isEmpty() && !maxQ.isEmpty()) {
                if (value == -1) {
                    int min_value = minQ.poll();
                    maxQ.remove(min_value);
                } else if (value == 1) {
                    int max_value = maxQ.poll();
                    minQ.remove(max_value);
                }
            }
        }
        
        if (minQ.isEmpty() && maxQ.isEmpty()) {
            return new int[]{0,0};
        } else {
            return new int[]{maxQ.poll(), minQ.poll()};
        }
    }
}
