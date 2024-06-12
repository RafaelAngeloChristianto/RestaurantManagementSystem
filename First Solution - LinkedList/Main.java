import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // calling the linkedlists outside of method functions so it can be transferred to other classes easier
    LinkedList<String> names = new LinkedList<String>(); // menu
    LinkedList<Double> prices = new LinkedList<Double>(); // menu
    LinkedList<String> cart_names = new LinkedList<String>(); // cart
    LinkedList<Double> cart_prices = new LinkedList<Double>(); // cart
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
        main.names.add("French Fries");
        main.names.add("French Baguette");
        main.names.add("Spaghetti Carbonara");
        main.names.add("Italian Hamburger");
        main.names.add("Fish N' Chips");
        main.prices.add(1.0);
        main.prices.add(3.0);
        main.prices.add(5.0);
        main.prices.add(7.0);
        main.prices.add(6.0);

        // main.firstRan();

    boolean run = true;
        // while (run) {
        //     switch (main.title_user_input) {
        //         case 1:
    System.out.println("Looks like you are a customer here! ");

    Customer customer = new Customer(main.names, main.prices, main.cart_names, main.cart_prices);

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
}

}