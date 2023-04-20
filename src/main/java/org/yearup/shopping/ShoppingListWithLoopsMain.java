package org.yearup.shopping;

import java.util.Scanner;

public class ShoppingListWithLoopsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Show the user a List of items for sale
        // Only show the product names and IDs, not the prices


        // Invite the user to buy something
        System.out.println("Hello! Welcome to my shop! ");
        while (true) {  // keep looping until user says "no"
            System.out.println("Would you like to purchase something from us? (Enter yes/no)");
            // Read in the user's response
            String userResponse = scanner.nextLine();
            if (userResponse.equals("yes")) {
                System.out.println("Great! Here is a list of items that are available today: \n");
            } else if (userResponse.equals("no")) {
                System.out.println("Thanks for stopping by!");
                return;
            }

            Item[] itemsForSale = ItemsForSale.itemsForSale;
            for (Item i : itemsForSale) {
                // System.out.println(i);
                if (!i.isInStock()) continue;
                System.out.println(i.getDescription() + " " + i.getProductID());
            }


            // Parse their choice and get that item from the list
            System.out.println("\nWhat is the product id of the item you desire?");
            String selectedProductID = scanner.nextLine();
            Item selectedItem = null;

            for (Item currentItemInListInTheLoop : itemsForSale) {
                if (selectedProductID.equals(currentItemInListInTheLoop.getProductID())) {
                    selectedItem = currentItemInListInTheLoop;
                    // Tell the user they can have it for a price!
                    System.out.println("I have found the item! \nIt'll cost you though.");
                    System.out.printf("This item is currently on sale for: $%8.2f\n", currentItemInListInTheLoop.getPrice());
                    break;
                }
            }
            // show them the price and ask them to accept it
            System.out.println("Do you accept this price? (yes/no)");
            // Read their response
            String acceptPrice = scanner.nextLine();


            //   if yes, tell them it's theirs
            if (acceptPrice.equals("yes")) {
                System.out.println("Perfect! let me take care of that for you! Would you like to purchase any other items?");
                String otherItems = scanner.nextLine();
                if (otherItems.equals("yes")){
                    continue;
                }else if (otherItems.equals("no")){
                    System.out.println("Thanks for stopping by!");
                    break;
                }

                //   if no, start over and show them the list again
            } else if (acceptPrice.equals("no")) {
                System.out.println("Oh no! Please check out some of my other items!");
            }
        }
    }
}

