//UCS
import java.util.*; 
public class UCS {     
    public static void findShortestPath(int[][] graph, int start, int end) { 
        int n = graph.length;         
        PriorityQueue<int[]> pq = new PriorityQueue<>( 
            (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0] 
        );        
        Set<Integer> visited = new HashSet<>(); 
        int[] distances = new int[n]; 
        int[] parents = new int[n]; 
        Arrays.fill(distances, Integer.MAX_VALUE); 
        Arrays.fill(parents, -1);         
        pq.add(new int[]{start, 0}); 
        distances[start] = 0;         
        while (!pq.isEmpty()) { 
            int[] current = pq.poll(); 
            int node = current[0]; 
            int cost = current[1]; 
            if (node == end) { 
                List<Integer> path = new ArrayList<>(); 
                for (int at = end; at != -1; at = parents[at]) { 
                    path.add(at); 
                } 
                Collections.reverse(path);                 
                System.out.println("Path: " + path); 
                System.out.println("Cost: " + cost); 
                return; 
            }             
            if (visited.contains(node)) continue; 
            visited.add(node); 
             
            for (int neighbor = 0; neighbor < n; neighbor++) { 
                int edgeCost = graph[node][neighbor]; 
                if (edgeCost > 0 && !visited.contains(neighbor)) { 
                    int newCost = cost + edgeCost; 
                    if (newCost < distances[neighbor]) { 
                        distances[neighbor] = newCost; 
                        parents[neighbor] = node; 
                        pq.add(new int[]{neighbor, newCost}); 
                    } 
                } 
            } 
        } 
        System.out.println("No path exists between " + start + " and " + end); 
    } 
    public static void main(String[] args) { 
        int[][] graph = { 
            {0, 1, 4, 0, 0}, 
            {1, 0, 2, 3, 2}, 
            {4, 2, 0, 0, 0}, 
            {0, 3, 0, 0, 1}, 
            {0, 2, 0, 1, 0} 
        }; 
        findShortestPath(graph, 0, 3);  
    } 
} 
