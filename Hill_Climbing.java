import java.util.*; 
public class HillClimbing { 
    static int calFunc(int x, int y) { 
        return 3 - (x * x + y * y); 
    } 
 
    static List<int[]> findNeighbors(int x, int y) { 
        List<int[]> neighbors = new ArrayList<>(); 
        neighbors.add(new int[]{x + 1, y + 1}); 
        neighbors.add(new int[]{x - 1, y - 1}); 
        neighbors.add(new int[]{x + 1, y - 1}); 
        neighbors.add(new int[]{x - 1, y + 1}); 
        return neighbors; 
    } 
    public static void main(String[] args) { 
        Random rand = new Random(); 
 
        int x = rand.nextInt(11) - 5; 
        int y = rand.nextInt(11) - 5; 
        System.out.printf("Starting at: (%d, %d) with value %d\n", x, y, calFunc(x, y)); 
        while (true) { 
            int currentVal = calFunc(x, y); 
            List<int[]> neighbors = findNeighbors(x, y); 
            int maxVal = Integer.MIN_VALUE; 
            int[] bestNeighbor = null; 
            for (int[] neighbor : neighbors) { 
                int val = calFunc(neighbor[0], neighbor[1]); 
                if (val > maxVal) { 
                    maxVal = val; 
                    bestNeighbor = neighbor; 
                } 
            } 
            if (maxVal > currentVal) { 
                x = bestNeighbor[0]; 
                y = bestNeighbor[1]; 
                System.out.printf("Moving to: (%d, %d) with value %d\n", x, y, maxVal); 
            } else { 
                System.out.printf("Reached peak at: (%d, %d) with value %d\n", x, y, currentVal); 
                break; 
            } 
        } 
    } 
} 
 
