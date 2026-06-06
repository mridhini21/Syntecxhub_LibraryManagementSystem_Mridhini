import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

public class lms {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        searchBook();
                        break;
                    case 4:
                        displayBooks();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Book b : books) {
                if (b.id == id) {
                    System.out.println("Book ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            books.add(new Book(id, title, author));
            System.out.println("Book added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
        }
    }

    static void removeBook() {
        try {
            System.out.print("Enter Book ID to remove: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Book b : books) {
                if (b.id == id) {
                    books.remove(b);
                    System.out.println("Book removed successfully!");
                    return;
                }
            }

            System.out.println("Book not found.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    static void searchBook() {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}