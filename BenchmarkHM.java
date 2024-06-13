import java.util.HashMap;

public class BenchmarkHM {
    HashMap<String, Double> menu = new HashMap<String, Double>();
    HashMap<String, Double> cart = new HashMap<String, Double>();



    public void HashMapTest() {

        System.gc();

        
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        long startTime = System.nanoTime(); 
        for (int i = 1 ; i <= 1000 ; i++) {
            cart.put("Food " + i, (double) i);
        }
        System.out.println(cart);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
    }

    public static void main(String[] args) {
        BenchmarkHM benchmark = new BenchmarkHM();
        benchmark.HashMapTest();
        
    }
}
