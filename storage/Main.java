
/**
 * A test file for wishlist and wishlist item
 *
 * @author Bryan Erickson
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<WishlistItem> clientAElements = Arrays.asList(
                new WishlistItem(1, "Apple", 5),
                new WishlistItem(2, "Orange", 10),
                new WishlistItem(3, "Onion", 3)
        );

        ArrayList<WishlistItem> clientAVector = new ArrayList<>(clientAElements);

        //A default client for testing purposes
        Wishlist clientA = new Wishlist(27, clientAVector);

        ArrayList<Wishlist> allWishlists = new ArrayList<>();

        allWishlists.add(clientA);

        //Used for all input within the menu
        Scanner menuInput = new Scanner(System.in);
        boolean endMenu = false;

        while (!endMenu) {
            System.out.println("Here are your options:");
            System.out.println("1: Add an item to a wishlist");
            System.out.println("2: Check if an item is within a wishlist");
            System.out.println("3: Get an item from a wishlist");
            System.err.println("4: View all items in a wishlist");
            System.out.println("5: Add a new wishlist");
            System.out.println("6: End the program");
            System.out.println("Enter a selection:");

            int menuSelection = menuInput.nextInt();

            switch (menuSelection) {
                case 1:
                    //Add an item to wishlist

                    System.out.println("Enter the client ID:");
                    Scanner clientIDScanner = new Scanner(System.in);

                    int idToCheck = clientIDScanner.nextInt();

                    boolean idInWishlist = false;
                    for (int i = 0; i < allWishlists.size(); i++) {

                        if (allWishlists.get(i).getClientID() == idToCheck) {
                            

                            System.out.println("Add a new item to the wishlist:");
                            int newID = menuInput.nextInt();
                            menuInput.nextLine();
                            String newItemName = menuInput.nextLine();
                            int newQuantity = menuInput.nextInt();

                            WishlistItem newItem = new WishlistItem(newID, newItemName, newQuantity);

                            allWishlists.get(i).insertItem(newItem);

                            idInWishlist = true;
                            break;
                        } 
                        
                    }

                    if(!idInWishlist){
                        System.out.println("Client ID not found");
                    }

                    break;
                case 2:
                    //Check if an item is in a wishlist

                    System.out.println("Enter client id:");
                    int idtoview = menuInput.nextInt();
                    boolean found = false;
                    for (int i = 0; i < allWishlists.size(); i++) {
                        if (allWishlists.get(i).getClientID() == idtoview) {

                            System.out.println("Enter product id:");
                            int productId = menuInput.nextInt();

                            for (int x = 0; x < allWishlists.get(i).getList().size(); x++) {
                                if (allWishlists.get(i).getList().get(x).getItemID() == productId) {

                                    found = true;
                                    System.out.println("Item found");
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("Item not found");
                            }

                        } else {
                            System.err.println("Id not found");
                            break;
                        }
                    }

                    break;
                case 3:
                    //Return an item from a wishlist
                    System.out.println("Enter client id:");
                    int idtoreturnitem = menuInput.nextInt();

                    boolean itemLocated = false;

                    for (int i = 0; i < allWishlists.size(); i++) {
                        if (allWishlists.get(i).getClientID() == idtoreturnitem) {

                            System.out.println("Enter product id:");
                            int productId = menuInput.nextInt();

                            for (int x = 0; x < allWishlists.get(i).getList().size(); x++) {
                                if (allWishlists.get(i).getList().get(x).getItemID() == productId) {

                                    itemLocated = true;

                                    //This simulates an item being returned 
                                    WishlistItem returnedItem = allWishlists.get(i).getList().get(x);

                                    System.out.println(returnedItem.toString());
                                    break;
                                }
                            }

                            if (!itemLocated) {
                                System.out.println("Item not found");
                            }

                        } else {
                            System.err.println("Id not found");
                            break;
                        }
                    }

                    break;
                case 4:
                    //Print all items from a wishlist

                    boolean itemInList = false;

                    System.out.println("Enter the client ID:");
                    
                    int idToView = menuInput.nextInt();

                    for (int i = 0; i < allWishlists.size(); i++) {

                        if (allWishlists.get(i).getClientID() == idToView) {
                            for (int x = 0; x < allWishlists.get(i).getList().size(); x++) {

                                System.out.println(allWishlists.get(i).getList().get(x).toString());

                                itemInList = true;
                            }
                            break;
                        } 

                    }

                    if(!itemInList){
                        System.out.println("Client ID not found");
                    }

                    break;
                case 5:
                    //Add a new wishlist

                    System.out.println("Enter the client ID for the new wishlist:");
                    int newClientId = menuInput.nextInt();

                    //An empty array list is needed to make a new wishlist
                    ArrayList<WishlistItem> newClientWishList = new ArrayList<>();
                    Wishlist newWishlist = new Wishlist(newClientId, newClientWishList);

                    allWishlists.add(newWishlist);

                    break;
                case 6:
                    endMenu = true;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        }
        menuInput.close();

    }
}
