public class ShoppingService {

    static void viewCart(User user) {

        if (user.cart.isEmpty()) {
            System.out.println("Cart is Empty");
        } else {
            System.out.println("\n===== Your Cart =====");

            for (String item : user.cart) {
                System.out.println(item);
            }
        }
    }

    static void checkout(User user) {

        if (user.cart.isEmpty()) {
            System.out.println("Cart is Empty");
            return;
        }

        int total = 0;

        System.out.println("\n===== Checkout =====");

        for (String item : user.cart) {

            for (Product product : ProductManager.products) {

                if (item.equals(product.name)) {
                    System.out.println(
                        item + " - Rs." + product.price
                    );

                    total += product.price;
                }
            }
        }

        System.out.println("Total Amount = Rs." + total);
        System.out.println("Order Placed Successfully!");

        user.cart.clear();
    }
}