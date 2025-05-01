//GBFS
import java.util.*; 
public class BestFirst { 
    public static void bestFirst(int[][] graph, int start, int end, int[] heuristics) { 
        PriorityQueue<Integer> pq = new PriorityQueue<>( 
            (a,b) -> heuristics[a] - heuristics[b] 
        );         
        boolean[] visited = new boolean[graph.length]; 
        int[] parents = new int[graph.length]; 
        Arrays.fill(parents, -1);         
        pq.add(start); 
        visited[start] = true;         
        while (!pq.isEmpty()) { 
            int current = pq.poll();             
            if (current == end) { 
                printPath(parents, end); 
                return; 
            }             
            for (int neighbor = 0; neighbor < graph.length; neighbor++) { 
                if (graph[current][neighbor] == 1 && !visited[neighbor]) { 
                    visited[neighbor] = true; 
                    parents[neighbor] = current; 
                    pq.add(neighbor); 
                } 
            } 
        } 
        System.out.println("No path found"); 
    } 
     
     static void printPath(int[] parents, int node) { 
        List<Integer> path = new ArrayList<>(); 
        while (node != -1) { 
            path.add(node); 
            node = parents[node]; 
        } 
        Collections.reverse(path); 
        System.out.println("Path: " + path); 
    } 
    public static void main(String[] args) { 
        int[][] graph = { 
            {0,1,1,0,0}, {1,0,1,1,1}, {1,1,0,0,0}, {0,1,0,0,1}, {0,1,0,1,0} 
        }; 
        int[] heuristics = {5, 3, 4, 2, 1}; // h values for nodes 0-4 
        bestFirst(graph, 0, 3, heuristics); 
    } 
} 
