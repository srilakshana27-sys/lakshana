import java.util.ArrayList;
import java.util.Scanner;

public class NexoMart {

    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== NexoMart =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    users.add(new User(name, email, password));

                    System.out.println("Registration Successful!");
                    break;

                case 2:

                    System.out.print("Enter Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPassword = sc.nextLine();

                    boolean found = false;

                    for (User user : users) {

                        if (user.email.equals(loginEmail)
                                && user.password.equals(loginPassword)) {

                            found = true;

                            System.out.println("Login Successful!");
                            System.out.println("Welcome " + user.name);

                            shoppingMenu(sc, user);
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Email or Password");
                    }

                    break;

                case 3:

                    System.out.println("Thank You for using NexoMart!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }

    static void shoppingMenu(Scanner sc, User user) {

        while (true) {

            System.out.println("\n===== NexoMart Shopping Menu =====");
            System.out.println("1. Browse Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Logout");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:

                    ProductManager.displayProducts();
                    break;

                case 2:

                    ProductManager.displayProducts();

                    System.out.print("Enter Product Number: ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    if (p >= 1 && p <= ProductManager.products.length) {

                        user.cart.add(
                            ProductManager.products[p - 1].name
                        );

                        System.out.println(
                            ProductManager.products[p - 1].name
                            + " Added to Cart."
                        );

                    } else {
                        System.out.println("Invalid Product");
                    }

                    break;

                case 3:

                    ShoppingService.viewCart(user);
                    break;

                case 4:

                    ShoppingService.checkout(user);
                    break;

                case 5:

                    System.out.println("Logged Out Successfully!");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}