//BFS
import java.util.*; 
public class SimpleBFS { 
    public static void findPath(int[][] graph, int start, int end) { 
        int n = graph.length; 
        Queue<Integer> queue = new LinkedList<>(); 
        boolean[] visited = new boolean[n]; 
        int[] parents = new int[n]; 
        Arrays.fill(parents, -1);  
        queue.add(start); 
        visited[start] = true;         
        while (!queue.isEmpty()) { 
            int current = queue.poll();             
            if (current == end) { 
                List<Integer> path = new ArrayList<>(); 
                for (int at = end; at != -1; at = parents[at]) { 
                    path.add(at); 
                } 
                Collections.reverse(path);                 
                System.out.println("Path: " + path); 
                return; 
            }             
            for (int neighbor = 0; neighbor < n; neighbor++) { 
                if (graph[current][neighbor] == 1 && !visited[neighbor]) { 
                    visited[neighbor] = true; 
                    parents[neighbor] = current; 
                    queue.add(neighbor); 
                } 
            } 
        }        
        System.out.println("No path exists between " + start + " and " + end); 
    } 
    public static void main(String[] args) { 
        int[][] graph = { 
            {0, 1, 1, 0, 0}, 
            {1, 0, 1, 1, 1}, 
            {1, 1, 0, 0, 0}, 
            {0, 1, 0, 0, 1}, 
            {0, 1, 0, 1, 0} 
        }; 
        findPath(graph, 0, 3); 
    }
}
