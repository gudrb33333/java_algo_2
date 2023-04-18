package programmers.lv3;

import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int n, int[][] computers) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Deque<Integer> nodeQueue = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> needVisited = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> graphValue = new ArrayList<>();
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    graphValue.add(j);
                }
            }
            needVisited.add(i);
            graph.put(i, graphValue);
        }

        dfs(graph, needVisited, visited, nodeQueue, 0);

        return answer;
    }

    private void dfs(
            Map<Integer, List<Integer>> graph,
            List<Integer> needVisited,
            List<Integer> visited,
            Deque<Integer> nodeQueue,
            int startNode
    ) {
        nodeQueue.add(startNode);

        while (!nodeQueue.isEmpty()) {
            int node = nodeQueue.pop();

            if (!visited.contains(node)) {
                visited.add(node);

                for (int item : graph.get(node)) {
                    nodeQueue.add(item);
                }
            }
        }

        answer += 1;

        // needVisited에서 visited 요소들을 제거하여 차집합 구하기
        List<Integer> difference = new ArrayList<>(needVisited);
        difference.removeAll(visited);

        if (!difference.isEmpty()) {
            int newStartNode = difference.get(0);
            dfs(graph, needVisited, visited, nodeQueue, newStartNode);
        }
    }
}
