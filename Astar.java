//A* algorithm
import java.util.*; 
public class AStar { 
        static void printPath(int[] parents, int node) { 
        List<Integer> path = new ArrayList<>(); 
        while (node != -1) { 
            path.add(node); 
            node = parents[node]; 
        } 
        Collections.reverse(path); 
        System.out.println("Path: " + path); 
    } 
    public static void aStar(int[][] graph, int start, int end, int[] heuristics) { 
        // Priority queue sorted by f(n) = g(n) + h(n) 
        PriorityQueue<int[]> pq = new PriorityQueue<>( 
            (a,b) -> (a[1] + heuristics[a[0]]) - (b[1] + heuristics[b[0]]) 
        );         
        boolean[] visited = new boolean[graph.length]; 
        int[] gValues = new int[graph.length]; 
        int[] parents = new int[graph.length]; 
        Arrays.fill(gValues, Integer.MAX_VALUE); 
        Arrays.fill(parents, -1); 
         
        pq.add(new int[]{start, 0}); 
        gValues[start] = 0; 
         
        while (!pq.isEmpty()) { 
            int[] current = pq.poll(); 
            int node = current[0]; 
               if (node == end) { 
                printPath(parents, end); 
                return; 
            }             
            if (visited[node]) continue; 
            visited[node] = true;             
            for (int neighbor = 0; neighbor < graph.length; neighbor++) { 
                if (graph[node][neighbor] > 0) { 
                    int newG = gValues[node] + graph[node][neighbor]; 
                    if (newG < gValues[neighbor]) { 
                        gValues[neighbor] = newG; 
                        parents[neighbor] = node; 
                        pq.add(new int[]{neighbor, newG}); 
                    } 
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
            {0,2,3,0,0}, {2,0,1,4,2}, {3,1,0,0,0}, {0,4,0,0,1}, {0,2,0,1,0} 
        }; 
        int[] heuristics = {5, 3, 4, 2, 1}; 
        aStar(graph, 0, 3, heuristics); 
    } 
} 
  
