import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class BenchmarkLL {
    LinkedList<String> names = new LinkedList<String>();
    LinkedList<Double> prices = new LinkedList<Double>();
    LinkedList<String> cart_names = new LinkedList<String>();
    LinkedList<Double> cart_prices = new LinkedList<Double>();
    
    public void LinkedListAddTest() {

        System.gc();

        
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        long startTime = System.nanoTime(); 
        for (int i = 1 ; i <= 10000 ; i++) {
            cart_names.add("Food " + i);
        }
        System.out.println(cart_names);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("================================");
        System.out.println("Adding...");
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
        System.out.println("================================");
    }

    public void LinkedListDeleteTest() {
        long startTime = System.nanoTime(); 

        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Removing elements: " + cart_names.size());
        for (int i = 0 ; i < cart_names.size() ; i++) {
            cart_names.remove(i);
        }



        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
        System.out.println("================================");
    }

    public void LinkedListSearchTest() {
        long startTime = System.nanoTime(); 

        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        String target = "1";
        int counter = 0;
        System.out.println("Searching: " + target);
        for (int i = 0 ; i < cart_names.size() ; i++) {
            if (cart_names.get(i).contains(target)) {
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



    public void LinkedListSortingTest() {
        long startTime = System.nanoTime(); 

        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();


        for (int i = 1 ; i <= 10000 ; i++) {
            names.add("Food " + i);
            Random random = new Random();
            prices.add(random.nextDouble(1, 1000));
        }

        FoodDetail[] paired = new FoodDetail[names.size()];
        for (int i = 0 ; i < names.size() ; i++) {
            paired[i] = new FoodDetail(names.get(i), prices.get(i));
        }        

        Arrays.sort(paired, (a, b) -> Double.compare(a.food_price, b.food_price));


        System.out.println("Sorting " + prices.size());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration);

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("Space: " + memoryUsed);
        System.out.println("================================");

    }



    public static void main(String[] args) {
        BenchmarkLL benchmark = new BenchmarkLL();
        benchmark.LinkedListAddTest();
        benchmark.LinkedListSearchTest();
        benchmark.LinkedListSortingTest();
        benchmark.LinkedListDeleteTest();
    }
}