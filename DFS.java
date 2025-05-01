//DFS
import java.util.*; 
class DFS { 
    public static void FindPath(int graph[][], int start, int end) { 
        Stack<Integer> stack = new Stack<>(); 
        boolean[] visited = new boolean[graph.length]; 
        int[] parents = new int[graph.length]; 
        Arrays.fill(parents,-1); 
        stack.push(start); 
        visited[start] = true; 
        while(!stack.isEmpty()){ 
            int current = stack.pop(); 
            if(current == end){ 
                printPath(parents,end); 
                return; 
            } 
            for(int neighbour=graph.length - 1; neighbour>=0;neighbour--) { 
                if(graph[current][neighbour]==1 && !visited[neighbour]){ 
                    visited[neighbour] = true; 
                    parents[neighbour] = current; 
                    stack.push(neighbour); 
                } 
            } 
        } 
        System.out.println("No path found"); 
    } 
    public static void printPath(int[] parents, int node) 
    { 
        List<Integer> path = new ArrayList<>(); 
        while (node != -1) 
        { 
            path.add(node); 
            node = parents[node]; 
        } 
        Collections.reverse(path); 
        System.out.println("Path " +path); 
    } 
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the number of vertices"); 
        int n = sc.nextInt(); 
        int graph[][] = new int[n][n]; 
        for(int i = 0; i<n; i++) 
        { 
            for(int j = 0; j<n; j++) 
            { 
                System.out.println("Is there a relation between "+i+" and "+j+" (1 if yes and 0 if 
no)"); 
                graph[i][j] = sc.nextInt(); 
            } 
        } 
        System.out.println("Enter the start node"); 
        int start = sc.nextInt(); 
        System.out.println("Enter the end node"); 
        int end = sc.nextInt(); 
        FindPath(graph, start, end); 
    } 
}
