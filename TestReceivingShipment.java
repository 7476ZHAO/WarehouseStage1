public class TestReceivingShipment {
    public static void main(String[] args) {
        ProductList list = new ProductList();
        list.addProduct("Apple", 1.5, 10);
        list.addProduct("Banana", 0.8, 20);
        list.addProduct("Orange", 1.2, 15);

        ReceivingShipment shipment = new ReceivingShipment(list);

        System.out.println("----BEFORE SHIPMENT----");
        shipment.printAllProducts();

        shipment.receiveShipment("Apple", 50);
        shipment.receiveShipment("Orange", 30);

        System.out.println("\n----AFTER SHIPMENT----");
        shipment.printAllProducts();
    }
}
