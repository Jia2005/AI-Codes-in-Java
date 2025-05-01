//DFID
import java.util.*; 
public class SimpleDFID { 
    public static void dfid(int[][] graph, int start, int end) { 
        for (int depth = 0; depth < graph.length; depth++) { 
            boolean[] visited = new boolean[graph.length]; 
            int[] parents = new int[graph.length]; 
            Arrays.fill(parents, -1); 
            if (dls(graph, start, end, depth, visited, parents)) 
                return; 
        } 
        System.out.println("No path found"); 
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
        dfid(graph, 0, 3); 
    } 
}
