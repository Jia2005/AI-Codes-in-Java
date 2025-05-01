//DLS
import java.util.*; 
public class DLS { 
        static void printPath(int[] parents, int node) { 
        List<Integer> path = new ArrayList<>(); 
        while (node != -1) { 
            path.add(node); 
            node = parents[node]; 
        } 
        Collections.reverse(path); 
        System.out.println("Path: " + path); 
    } 
    public static boolean dls(int[][] graph, int current, int end, int limit, boolean[] visited, int[] 
parents) { 
        if (current == end) { 
            printPath(parents, end); 
            return true; 
        } 
        if (limit <= 0) return false; 
        visited[current] = true; 
        for (int neighbor =  graph.length-1; neighbor>=0; neighbor--) { 
            if (graph[current][neighbor] == 1 && !visited[neighbor]) { 
                parents[neighbor] = current; 
                if (dls(graph, neighbor, end, limit-1, visited, parents)) 
                    return true; 
            } 
        } 
        return false; 
    } 
     
    public static void main(String[] args) { 
        int[][] graph = { 
            {0,1,1,0,0}, {1,0,1,1,1}, {1,1,0,0,0}, {0,1,0,0,1}, {0,1,0,1,0} 
        }; 
        boolean[] visited = new boolean[graph.length]; 
        int[] parents = new int[graph.length]; 
        Arrays.fill(parents, -1); 
        if (!dls(graph, 0, 1, 1, visited, parents)) 
            System.out.println("No path within depth limit"); 
    } 
} 
