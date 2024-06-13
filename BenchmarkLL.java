import java.util.LinkedList;

public class BenchmarkLL {
    LinkedList<String> names = new LinkedList<String>();
    LinkedList<Double> prices = new LinkedList<Double>();
    LinkedList<String> cart_names = new LinkedList<String>();
    LinkedList<Double> cart_prices = new LinkedList<Double>();
    
    public void LinkedListTest() {

        System.gc();

        
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        long startTime = System.nanoTime(); 
        for (int i = 1 ; i <= 1000 ; i++) {
            cart_names.add("Food " + i);
        }
        System.out.println(cart_names);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
    }

    public static void main(String[] args) {
        BenchmarkLL benchmark = new BenchmarkLL();
        benchmark.LinkedListTest();
        
    }
}