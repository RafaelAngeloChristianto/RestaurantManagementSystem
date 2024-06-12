// import java.util.LinkedList;
// import java.util.Scanner;

// // inheritance | owner class is inheriting from the Main class
// public class Owner extends Main {

//     // initializing variables
//     Scanner input = new Scanner(System.in);
//     Scanner name_input = new Scanner(System.in);
//     Scanner price_input = new Scanner(System.in);

//     // calling the linked lists from the main class
//     LinkedList<String> names;
//     LinkedList<Double> prices;

//     // constructor
//     public Owner(LinkedList<String> names, LinkedList<Double> prices) {
//         this.names = names;
//         this.prices = prices;
//     }
    
//     int action_number_index = 1;
//     int action_owner_input;
//     public void firstPrompt() {
//         System.out.println("==============================================");
//         System.out.println("**Welcome Restaurant Owner**");

//         System.out.println("Action Number " + (action_number_index++) + "!");

//         System.out.println("What kind of action would you like to perform this time? ");
//         // iterate
//         String[] owner_actions = {"See The Menu", "Add Food To The Menu", "Remove Food From The Menu", "Edit The Food's Names", "Edit The Food's Price", "Remove All Food From The Menu", "Add Discount To Food", "Exit/Cancel"};
//         for (int i = 0 ; i < owner_actions.length ; i++) {
//             System.out.println("(" + (i+1) + ") " + owner_actions[i]);
//         }
//         System.out.print("Pick the number: ");
//         action_owner_input = input.nextInt();
        
//         // if the user inputs a number that is exceeding the number of options available it will say invalid input and redo the method
//         if (action_owner_input > owner_actions.length) {

//             System.out.println("Invalid Input!");
//             firstPrompt();
//         } 
//     }
    

//     public void seeTheMenu() {
//         if (names.size() == 0) {
//             System.out.println("Menu Empty!");
//         }


//         System.out.println("==============================================");
        
//         System.out.println("The food served in FarLeaf's Restaurant are as follows: ");
//         for (int i = 0 ; i < names.size() ; i++) {
//             System.out.println(names.get(i) + " | " + prices.get(i));
//         }
//         input.nextLine();


//         System.out.println("==============================================");
//         anotherAction();
//     }
    
//     public void addFoodToMenu() {
//         String added_food;
//         double added_food_price;
//         System.out.println("==============================================");

//         System.out.println("What food would you like to add to the menu? ");
//         added_food = name_input.nextLine();

                
//         System.out.println("Price of |" + added_food + "|? " );
//         added_food_price = price_input.nextDouble();
//         input.nextLine();
        
//         names.add(added_food);
//         prices.add(added_food_price);
//         System.out.println("|" + names.getLast() + "| " + "has been added to the menu with a price of " + "|$" + prices.getLast() + "|");


//         System.out.println("==============================================");

//         anotherAction();
//     }

//     public void removeFoodFromMenu() {
//         if (names.size() == 0) {
//             System.out.println("Add something to the menu first! ");
//         } else if (names.size() == 1) {
//             System.out.println("Are you sure you want to remove |" + names.getLast() + "|? ");
//             System.out.println("|" + names.getLast() + "| is the only food in the menu at the moment");

//             System.out.println("y = yes | n = no");
//             char remove_one_food = input.nextLine().charAt(0);

//             switch (remove_one_food) {
//                 case 'y':
//                     /*
//                         In this case the print statement has to go first
//                         It is because if the last element of names is removed already, then names.getLast() would be null  
//                     */

//                     System.out.println("Okay, removing " + names.getLast());

//                     names.removeLast();
//                     prices.removeLast();
//                     break;
//                 case 'n':
//                     System.out.println("Okay");
//                     anotherAction();
//                     break;
//                 default:

//                     System.out.println("Invalid Input! ");
//                     removeFoodFromMenu();
//                     break;
//             }
//         } else {
//             System.out.println("==============================================");

//             System.out.println("What food would you like to remove from the menu? ");
//             for (int i = 0 ; i < names.size() ; i++) {
//                 System.out.println("(" + (i+1) + ") | " + names.get(i));
//             }
//             System.out.print("Pick the number: ");
//             int number_of_choice = input.nextInt();

//             System.out.println("|"+ names.get(number_of_choice - 1) + "| has been removed from the menu");
//             names.remove(number_of_choice - 1);
//             prices.remove(number_of_choice - 1);
//             input.nextLine();
            
//             System.out.println("==============================================");
//             anotherAction();
//         }
//     }


//     public void editFoodName() {
//         System.out.println("==============================================");
//         System.out.println("Which food whose name would you like to change?");
//         for (int i = 0 ; i < names.size() ; i++) {
//             System.out.println("(" + (i+1) + ") | " + names.get(i));
//         }
//         System.out.print("Pick the number: ");
//         int number_of_choice = input.nextInt();

//         System.out.println("==============================================");

//         System.out.println("|" + names.get(number_of_choice - 1) + "|");
//         System.out.println("Type the new name: ");
//         String new_name = input.next();

//         System.out.println("|" + names.get(number_of_choice - 1) + "|" + " has been changed to |" + new_name + "|");
//         names.set(number_of_choice - 1, new_name);
//         input.nextLine();

//         System.out.println("==============================================");
//         anotherAction();
//     }




//     public void editFoodPrice() {
//         System.out.println("==============================================");
//         System.out.println("Which food whose price would you like to change?");
//         for (int i = 0 ; i < names.size() ; i++) {
//             System.out.println("(" + (i+1) + ") | " + names.get(i) + " | " + prices.get(i));
//         }
//         System.out.print("Pick the number: ");
//         int number_of_choice = input.nextInt();

//         System.out.println("==============================================");

//         System.out.println("|" + names.get(number_of_choice - 1) + "| with a price of |" + prices.get(number_of_choice - 1) + "| ");
//         System.out.println("Type the new price: ");
//         Double new_price = input.nextDouble();

//         System.out.println("The price of |" + names.get(number_of_choice - 1) + "|" + " has been changed from " + prices.get(number_of_choice - 1) + " to |" + new_price + "|");
//         prices.set(number_of_choice - 1, new_price);
//         input.nextLine();

//         System.out.println("==============================================");
//         anotherAction();
//     }


//     public void removeAllFood() {
//         System.out.println("==============================================");
//         System.out.println("Are you sure you want to remove all food from the menu? ");
//         System.out.println("(y) yes    |    (n) no");
//         char remove_all_input = input.next().charAt(0);
//         input.nextLine();

//         System.out.println("Menu Emptied!");
//         System.out.println("==============================================");

//         if (remove_all_input == 'y') {
//             names.clear();
//             prices.clear();
//             anotherAction();
//         } else {
//             System.out.println("Okay");
//             firstRan();
//         }
//     }

//     public void addDiscount() {
        
//     }
    
//     // a method function that will be used to loop back to the firstPrompt() method function everytime the users enters a yes
//     public void anotherAction() {
//         System.out.println("Would you like to perform another action? ");
//         System.out.println("y = yes | n = no");
        
//         /*
//             Since, in Java, there is no nextChar() function, so we just used the normal nextLine(), and charAt(0), so we only get the first letter of the user input
//         */
//         char another_action = input.nextLine().charAt(0);

//         if (another_action == 'y') {
//             // calling the firstPrompt() method function
//             firstPrompt();
//         } else if (another_action == 'n') {
//             System.out.println("==============================================");
//             System.out.println("Okay! See you another time!");
        
//             // closes the program
//             System.exit(0);
//         } else {
//             System.out.println("Invalid Input!");
//             anotherAction();
//         }
//     }
// }
