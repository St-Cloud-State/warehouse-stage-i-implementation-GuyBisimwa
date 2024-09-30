import java.util.Scanner;

public class UserInterface {
    private ProductList productList;
    private Scanner scanner;

    public UserInterface() {
        productList = new ProductList();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    searchProductById();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Warehouse Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. Display All Products");
        System.out.println("3. Search Product by ID");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product sale price: ");
        double salePrice = Double.parseDouble(scanner.nextLine());
        
        Product newProduct = new Product(name, quantity, salePrice);
        productList.addProduct(newProduct);
        System.out.println("Product added successfully: " + newProduct);
    }

    private void displayAllProducts() {
        System.out.println("Product List:");
        System.out.println(productList);
    }

    private void searchProductById() {
        System.out.print("Enter product ID to search: ");
        String id = scanner.nextLine();
        Product foundProduct = productList.searchProductById(id);
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}
