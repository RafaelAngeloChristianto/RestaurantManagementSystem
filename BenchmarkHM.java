import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class BenchmarkHM {
    HashMap<String, Double> menu = new HashMap<String, Double>();
    HashMap<String, Double> cart = new HashMap<String, Double>();



    public void HashMapAddTest() {

        System.gc();

        
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        long startTime = System.nanoTime(); 
        for (int i = 1 ; i <= 10000 ; i++) {
            cart.put("Food " + i, (double) i);
        }
        System.out.println(cart);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("================================");
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
        System.out.println("================================");
    }

    public void HashMapSearchTest() {
        long startTime = System.nanoTime(); 


        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        String target = "1";
        int counter = 0;
        System.out.println("Searching: " + target);
        for (String one : cart.keySet()) {
            if (one.contains(target)) {
                counter++;
            }
        }
        System.out.println("Elements found: " + counter);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
        System.out.println("================================");
    }


     public void HashMapSortingTest() {
        long startTime = System.nanoTime(); 

        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();


        for (int i = 1 ; i <= 10000 ; i++) {
            Random random = new Random();
            menu.put("Food " + i, random.nextDouble(1, 1000));
        }

        FoodDetail[] paired = new FoodDetail[menu.size()];
        for (int i = 0 ; i < menu.size() ; i++) {
            Object one_by_one = menu.keySet().toArray()[i];
            paired[i] = new FoodDetail((String) one_by_one, menu.get(one_by_one));
        }        

        Arrays.sort(paired, (a, b) -> Double.compare(a.food_price, b.food_price));



        System.out.println("Sorting " + menu.size());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
        System.out.println("================================");

    }

    public void HashMapDeleteTest() {
        long startTime = System.nanoTime(); 

        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Removing elements: " + cart.size());
        for (Object one : cart.keySet().toArray()) {
            cart.remove(one);
        }



        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);

    }


    

    public static void main(String[] args) {
        BenchmarkHM benchmark = new BenchmarkHM();
        benchmark.HashMapAddTest();
        benchmark.HashMapSearchTest();
        benchmark.HashMapSortingTest();
        benchmark.HashMapDeleteTest();

    }
}
