package programmers.lv3;

import javafx.util.Pair;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    
    private int answer;
    private HashSet<String> visited;
    private PriorityQueue<Pair<String, Integer>> priorityQueue;
    
    public Solution() {
        this.answer = 0;
        this.visited = new HashSet<String>();
        this.priorityQueue = new PriorityQueue<>(
            Comparator.comparing(Pair<String, Integer>::getValue)
        );
    }
    
    public int solution(String begin, String target, String[] words) {
        this.bfs(begin, target, words);
        
        return this.answer;
    }
    
    private void bfs(String begin, String target, String[] words) {
        Pair<String, Integer> beginPair = new Pair(begin, 0);
        
        this.priorityQueue.add(beginPair);
        
        while (!this.priorityQueue.isEmpty()) {
            Pair<String, Integer> nodePair = this.priorityQueue.poll();
            
            if (!this.visited.contains(nodePair.getKey())) {
                this.visited.add(nodePair.getKey());
                
                for (String word : words) {
                    int temp = 0;
                    for (int i = 0; i < word.length(); i++) {
                        if (nodePair.getKey().charAt(i) != word.charAt(i)) {
                            temp += 1;
                        }
                    }
                    
                    if (temp == 1) {
                        if (word.equals(target)) {
                            this.answer = nodePair.getValue() + 1;
                            return;
                        }
                        this.priorityQueue.add(new Pair(word, nodePair.getValue() + 1));
                    }
                }
                
            }
            
        }
    }
}
