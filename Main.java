import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Library library = Library.loadData();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. List All Books");
            System.out.println("4. List All Members");
            System.out.println("5. Check Out Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit and Save");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(isbn, title, author));
                    System.out.println("Book added successfully.");
                    break;
                case "2":
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    String memberId = UUID.randomUUID().toString().substring(0, 8);
                    library.addMember(new Member(memberId, name));
                    System.out.println("Member added successfully with ID: " + memberId);
                    break;
                case "3":
                    library.displayAllBooks();
                    break;
                case "4":
                    library.displayAllMembers();
                    break;
                case "5":
                    System.out.print("Enter ISBN of book to check out: ");
                    String checkoutIsbn = scanner.nextLine();
                    library.checkoutBook(checkoutIsbn);
                    break;
                case "6":
                    System.out.print("Enter ISBN of book to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                case "7":
                    Library.saveData(library);
                    System.out.println("Data saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}