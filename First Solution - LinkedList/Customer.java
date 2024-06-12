import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

// inheritance | customer class is inheriting from the Main class
public class Customer extends Main {
    Scanner input = new Scanner(System.in);

    // calling the linked lists from the main class
    LinkedList<String> names;
    LinkedList<Double> prices;
    LinkedList<String> cart_names;
    LinkedList<Double> cart_prices;

    // constructor
    public Customer(LinkedList<String> names, LinkedList<Double> prices, LinkedList<String> cart_names, LinkedList<Double> cart_prices) {
        this.names = names;
        this.prices = prices;
        this.cart_names = cart_names;
        this.cart_prices = cart_prices;
    }
    
    int action_customer_input;
    public void firstCustomerPrompt() {
        System.out.println("==============================================");
        System.out.println("**Welcome Lovely Customers**");

        System.out.println("What kind of action would you like to perform? ");
        // iterate
        String[] owner_actions = {"See The Menu", "Add Food To Cart", "Remove Food From Cart", "See The Cart", "Empty The Cart", "Sort Price:Lowest to Highest", "Sort Price:Highest to Lowest","Search By Keyword", "See Total Bill", "Exit/Cancel"};
        for (int i = 0 ; i < owner_actions.length ; i++) {
            System.out.println("(" + (i+1) + ") " + owner_actions[i]);
        }
        System.out.print("Pick the number: ");
        action_customer_input = input.nextInt();

        if (action_customer_input > owner_actions.length) {
            System.out.println("Invalid Input!");
            firstCustomerPrompt();
        }
    }

    public void seeTheMenu() {
        long start_time = System.nanoTime();

        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        System.out.println("==============================================");
        for (int i = 0 ; i < names.size() ; i++) {
            System.out.println(names.get(i) + " | $" + prices.get(i));
        }
        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);

        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);

        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }



    public void addFoodToCart() {
        long start_time = System.nanoTime();

        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("==============================================");
        System.out.println("Which food would you like to add to your cart? ");


        for (int i = 0 ; i < names.size() ; i++) {
            System.out.println("(" + (i+1) + ") " + names.get(i) + " | " + prices.get(i));
        }

        System.out.print("Pick the number: ");
        int add_to_cart_input = input.nextInt();

        cart_names.add(names.get(add_to_cart_input - 1));
        cart_prices.add(prices.get(add_to_cart_input - 1));

        System.out.println("|" + names.get(add_to_cart_input - 1) + "|" + " has been added to your cart with a charge of $|" + prices.get(add_to_cart_input - 1) + "| ");

        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);


        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);


        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }


    public void removeFoodFromCart() {
        long start_time = System.nanoTime();
        
        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        if (cart_names.size() == 0) {
            System.out.println("Cart is empty!");
            // anotherAction();
        } else if (cart_names.size() == 1) {
            System.out.print("Are you sure you want to remove " + cart_names.get(0) + " from your cart? ");
            char one_remove_input = input.nextLine().charAt(0);
            input.nextLine();

            if (one_remove_input == 'y') {
                System.out.println(cart_names.get(0) + "has been removed from the cart");
                cart_names.remove(0);
                cart_prices.remove(0);
            } else {
                System.out.println("Okay");
                // anotherAction();
            }
        } else {
            System.out.println("==============================================");
            System.out.println("Which food would you like to remove from your cart? ");

            for (int i = 0 ; i < cart_names.size() ; i++) {
                System.out.println("(" + (i+1) + ") " + cart_names.get(i) + " | " + cart_prices.get(i));
            }
            input.nextLine();

            System.out.print("Pick the number: ");
            int remove_from_cart_input = input.nextInt();

            System.out.println(cart_names.get(remove_from_cart_input - 1) + " has been removed from your cart");
            cart_names.remove(cart_names.get(remove_from_cart_input - 1));
            cart_prices.remove(cart_prices.get(remove_from_cart_input - 1));
        }
        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);




        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);

        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }


    public void seeTheCart() {
        long start_time = System.nanoTime();
       
        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        if (cart_names.size() == 0) {
            System.out.println("==============================================");
            System.out.println("Cart is Empty");
        } else {
            System.out.println("==============================================");
            System.out.println("Here is your *cart*: ");
            for (int i = 0 ; i < cart_names.size() ; i++) {
                System.out.println(cart_names.get(i) + " | " + cart_prices.get(i));
            }
        }

        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);
        

        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);


        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
      
    }

    public void emptyTheCart() {
        long start_time = System.nanoTime();



        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        System.out.println("==============================================");
        System.out.println(cart_names.size() + " foods from cart is cleared");
        for (int i = 0 ; i < cart_names.size() ; i++) {
            cart_names.pop();
        }
        
        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);


        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);




        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }

    public void sortLowToHigh() {
        long start_time = System.nanoTime();

        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        FoodDetail[] paired = new FoodDetail[names.size()];
        for (int i = 0 ; i < names.size() ; i++) {
            paired[i] = new FoodDetail(names.get(i), prices.get(i));
        }        

        Arrays.sort(paired, (a, b) -> Double.compare(a.food_price, b.food_price));

        System.out.println("==============================================");

        for (FoodDetail pair : paired) {
            System.out.println(pair.food_name + " | $" + pair.food_price);
        }

        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);


        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);



        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }
    
    

    public void sortHighToLow() {
        long start_time = System.nanoTime();

        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();



        FoodDetail[] paired = new FoodDetail[names.size()];
        for (int i = 0 ; i < names.size() ; i++) {
            paired[i] = new FoodDetail(names.get(i), prices.get(i));
        }        

        Arrays.sort(paired, (a, b) -> Double.compare(b.food_price, a.food_price));

        System.out.println("==============================================");

        for (FoodDetail pair : paired) {
            System.out.println(pair.food_name + " | $" + pair.food_price);
        }
    

        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);



        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);


        input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }   



    public void searchByKeyword() {
        long start_time = System.nanoTime();


        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        System.out.println("==============================================");
        System.out.print("Enter keyword: ");
        input.nextLine();
        String keyword = input.nextLine();
        System.out.println("Names of food that contain the keyword: " + keyword);
        boolean found = false;
        for (int i = 0 ; i < names.size() ; i++) {
            if (names.get(i).toUpperCase().contains(keyword.toUpperCase())) {
                System.out.println(names.get(i));
                found = true;
            } 
        }

        if (!found) {
            System.out.println("No matches found");
        }

        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);

        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);


        // input.nextLine();
        System.out.println("==============================================");
        anotherAction();
    }


    public void seeTotalBill() {
        long start_time = System.nanoTime();



        Runtime runtime = Runtime.getRuntime();
        long start_memory = runtime.totalMemory() - runtime.freeMemory();


        System.out.println("==============================================");
        System.out.println("Total check will be as follows: ");
        for (int i = 0 ; i < cart_names.size() ; i++) {
            System.out.println(cart_names.get(i) + " | " + cart_prices.get(i));
        }
    
        double total_price = 0;
        for (int i = 0 ; i < cart_prices.size() ; i++) {
            total_price = cart_prices.get(i) + total_price;
        }
        System.out.println("Total = $" + total_price);

        long end_time = System.nanoTime();
        long duration_time = end_time - start_time;
        System.out.println("Time: " + duration_time);


        long end_memory = runtime.totalMemory()  - runtime.freeMemory();
        long used_memory = end_memory - start_memory;
        System.out.println("Space:" + used_memory);


        System.out.println("Please pay at the counter! Do not forget to come back! For now, good bye.");
        System.exit(0);
    }


    public void anotherAction() {
        System.out.println("Would you like to perform another action? ");
        System.out.println("y = yes | n = no");
        
        /*
            Since, in Java, there is no nextChar() function, so we just used the normal nextLine(), and charAt(0), so we only get the first letter of the user input
        */
        char another_action = input.nextLine().charAt(0);

        if (another_action == 'y') {
            // calling the firstPrompt() method function
            firstCustomerPrompt();
        } else if (another_action == 'n') {
            System.out.println("==============================================");
            System.out.println("Okay! See you another time!");
        
            // closes the program
            System.exit(0);
        } else {
            System.out.println("Invalid Input!");
            anotherAction();
        }
    }
    
}
