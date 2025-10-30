import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Client {
    private String id;
    private String name;
    private Wishlist<WishlistItem> wishlist;
    private float balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Client(String id, String name, float startingBalance) {
        this.id = id;
        this.name = name;
        this.wishlist = new ArrayList<>();
        this.balance = startingBalance;
    }

    // Accessors
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getBalance(){
        return balance;
    }

    public float addToBalance(float addend){
        this.balance = balance + addend;
        return balance;
    }


    // Wishlist operations
    public void addToWishlist(WishlistItem wishlistitem) {
        wishlist.add(wishlistitem);
    }

    public Wishlist<WishlistItem> getWishlist() {
        return wishlist;
    }

    public void addTransaction(String description, double amount) {
        transactions.add(new Transaction(description, amount));
    }
    
    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    @Override
    public String toString() {
        return "Client id = " + id + " name = " + name + " balance = " + balance;
    }
}

