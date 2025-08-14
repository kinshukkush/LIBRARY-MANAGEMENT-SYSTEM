import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_FILE = "library.dat";
    
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    public void checkoutBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Success: Book \"" + book.getTitle() + "\" checked out.");
        } else if (book != null && !book.isAvailable()) {
            System.out.println("Error: Book is already checked out.");
        } else {
            System.out.println("Error: Book with ISBN " + isbn + " not found.");
        }
    }

    public void returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Success: Book \"" + book.getTitle() + "\" returned.");
        } else if (book != null && book.isAvailable()) {
            System.out.println("Error: Book was not checked out.");
        } else {
            System.out.println("Error: Book with ISBN " + isbn + " not found.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("---------------------\n");
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members in the system.");
            return;
        }
        System.out.println("\n--- Library Members ---");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("-----------------------\n");
    }

    public static void saveData(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(library);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static Library loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            return new Library();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new Library();
        }
    }
}