import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String name;
    private List<Product> wishlist;
    private float balance;

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
    public void addToWishlist(Product product) {
        wishlist.add(product);
    }

    public List<Product> getWishlist() {
        return wishlist;
    }

    @Override
    public String toString() {
        return "Client id = " + id + " name = " + name + " balance = " + balance;
    }
}
