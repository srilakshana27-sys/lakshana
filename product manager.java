public class ProductManager {

    static Product[] products = {
        new Product("Shoes", 1500),
        new Product("T-Shirt", 800),
        new Product("Watch", 2500),
        new Product("Bag", 1200),
        new Product("Headphones", 3000)
    };

    static void displayProducts() {
        System.out.println("\n===== Available Products =====");

        for (int i = 0; i < products.length; i++) {
            System.out.println(
                (i + 1) + ". " + products[i].name +
                " - Rs." + products[i].price
            );
        }
    }
}