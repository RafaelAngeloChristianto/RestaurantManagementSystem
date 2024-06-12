import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // calling the linkedlists outside of method functions so it can be transferred to other classes easier
    HashMap<String, Double> menu = new HashMap<String, Double>();
    HashMap<String, Double> cart = new HashMap<String, Double>();
    Scanner input = new Scanner(System.in);
    boolean active = true;

    // int title_user_input;
    // public void firstRan() {
    //     System.out.println("************************************************");

    //     System.out.println("Hello, Welcome to FarLeaf Restaurant!");

        
    //     String[] titles = {"Customer", "Restaurant Owner"};
    //     for (int i = 0 ; i < titles.length ; i++) {
    //         System.out.println("(" + (i+1) + ") " + titles[i]);
    //     }

    //     System.out.print("Pick the number: ");
    //     title_user_input = input.nextInt();

    //     // while (active) {
    //     //     if (title_user_input > titles.length) {
    //     //         firstRan();
    //     //     }
    //     // }
    // }
    
    public static void main(String[] args) {
        // calling the Main class itself to use the linkedlists and hashmap
        Main main = new Main();

        /*
            So, for the code below, I used the syntax of:
                className.methodFunctionName.function()
            1. In this particular case, the className is going to be main as names above in line 21, as the Main class needs to be defined again in its own class, as if not then the linked list cannot be used here.
            2. the methodFunctionName I put it as names the names of the linkedlists, as we need to add elements into it.
            3. the add() function is used to add elements to lists, in this case to the names linkedlist
        */
 
        main.menu.put("French Fries", 1.0);
        main.menu.put("French Baguette", 3.0);
        main.menu.put("Spaghetti Carbonara", 5.0);
        main.menu.put("Italian Hamburger", 7.0);
        main.menu.put("Fish N' Chips", 6.0);

        // main.firstRan();

        boolean run = true;
        // while (run) {
        //     switch (main.title_user_input) {
        //         case 1:
        System.out.println("Looks like you are a customer here! ");

        Customer customer = new Customer(main.menu, main.cart);

        customer.firstCustomerPrompt();

        while (run) {
            switch (customer.action_customer_input) {
                case 1:
                    customer.seeTheMenu();
                    break;
                case 2:
                    customer.addFoodToCart();
                    break;
                case 3:
                    customer.removeFoodFromCart();
                    break;
                case 4:
                    customer.seeTheCart();
                    break;
                case 5:
                    customer.emptyTheCart();
                    break;
                case 6:
                    customer.sortLowToHigh();
                    break;
                case 7:
                    customer.sortHighToLow();
                    break;
                case 8:
                    customer.searchByKeyword();
                    break;
                case 9:
                    customer.seeTotalBill();
                    break;
                case 10:
                    System.out.println("Okay! See you next time! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    customer.firstCustomerPrompt();
                    break;
            }
        }

                    // break;
                // case 2:
                    // call the owner class in this file and put it in a variable, own
                    // Owner own = new Owner(main.names, main.prices);
    
                    // call the firstPrompt() method function from owner class
                //     own.firstPrompt();
              
                //     while (run) {
                //         switch (own.action_owner_input) {
                //             case 1:
                //                 own.seeTheMenu();
                //                 break;
                //             case 2:
                //                 // call the addFoodToMenu() method function from owner class
                //                 own.addFoodToMenu();
                //                 break;
                //             case 3:
                //                 // call the removeFoodFromMenu() method function from owner class
                //                 own.removeFoodFromMenu();
                //                 break;
                //             case 4:
                //                 own.editFoodName();
                //                 break;
                //             case 5:
                //                 own.editFoodPrice();
                //                 break;
                //             case 6:
                //                 own.removeAllFood();
                //                 break;
                //             case 7:
                //                 own.addDiscount();
                //                 break;
                //             case 8:
                //                 System.out.println("Okay! See you next time! ");
                //                 System.exit(0);
                //                 break;
                //             default:
                //                 System.out.println("Invalid Input!");
                //                 own.firstPrompt();
                //                 break;
                //         }    
                //     }
                    
                //     break;
                // default:
                //     System.out.println("Invalid Input!");
    
                //     main.firstRan();
    
                //     break;
                // }
        }
}