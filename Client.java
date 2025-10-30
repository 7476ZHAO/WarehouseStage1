//package Pro1_Warehouse;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String name;
    private Wishlist wishlist = new Wishlist();
    private float balance;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

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

    public Wishlist getWishlist() {
        return wishlist;
    }

    // --- Add a new invoice ---
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    // --- Add a transaction ---
    public void addTransaction(String description, double amount) {
        transactions.add(new Transaction(description, amount));
    }
    
    // ---print all invoices for debugging or testing ---
    public void printInvoices() {
        System.out.println("Invoices for client " + name + ":");
        for (Invoice inv : invoices) {
            System.out.println("  " + inv.getId() + " | Total: $" + inv.getTotalCost());
        }
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

