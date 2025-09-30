/**
 * @author Bryan Erickson
 * The class file for a wishlist item
 */
public class WishlistItem {

    private final int itemId;
    private final String itemName;
    private final int desiredQuantity;

    public WishlistItem(int id, String name, int quantity) {
        this.itemId = id;
        this.itemName = name;
        this.desiredQuantity = quantity;
    }

    @Override
    public String toString() {
        return itemId + " " + itemName + " " + desiredQuantity;
    }

    public int getItemID() {
        return this.itemId;
    }

    public static void wishlistItem(String[] args) {

    }
}
