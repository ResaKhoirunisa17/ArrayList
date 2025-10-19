import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    int price;
    int qty;
    int subtotal;

    // constructor
    Item(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.subtotal = price * qty;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();

        String choice;
        int total = 0;

        // Input loop
        do {
            System.out.print("Enter item name: ");
            String name = input.nextLine();

            System.out.print("Enter price: ");
            int price = input.nextInt();

            System.out.print("Enter quantity: ");
            int qty = input.nextInt();
            input.nextLine(); // consume newline

            // Add new item
            Item newItem = new Item(name, price, qty);
            items.add(newItem);

            System.out.print("Add another item? (yes/no): ");
            choice = input.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        // Display all data
        System.out.printf("%-5s %-15s %-10s %-10s %-10s\n", "No", "Item", "Price", "qty", "subtotal");
        System.out.println("-------------------------------------------------------");

        int no = 1;
        for (Item i : items) {
            System.out.printf("%-5d %-15s %-10d %-10d %-10d\n", no, i.name, i.price, i.qty, i.subtotal);
            total += i.subtotal;
            no++;
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Total: " + total);

        input.close();
    }
}
