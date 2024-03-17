import java.util.Scanner;

public class CommandLineInterface {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter command (type 'help' for a list of commands): ");
            String command = scanner.nextLine();

            switch (command) {
                case "listbooks":
                    listBooks();
                    break;
                case "listpatrons":
                    // Print all patrons
                    break;
                case "addbook":
                    addBook(scanner);
                    break;
                case "addpatron":
                    // Add a new patron
                    addPatron(scanner);
                    break;
                case "showbook":
                    showBookDetails(scanner);
                    break;
                case "showpatron":
                    // Show patron details
                    break;
                case "borrow":
                    // Borrow a book
                    break;
                case "renew":
                    // Renew a book
                    break;
                case "return":
                    // Return a book
                    break;
                case "loadgui":
                    // Load the GUI version of the app
                    break;
                case "help":
                    printHelpMessage();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
            }
        }
        
        scanner.close();
    }
    private static void printHelpMessage() {
        System.out.println("Available commands:");
        System.out.println("listbooks - Print all books");
        System.out.println("listpatrons - Print all patrons");
        System.out.println("addbook - Add a new book");
        System.out.println("addpatron - Add a new patron");
        System.out.println("showbook - Show book details");
        System.out.println("showpatron - Show patron details");
        System.out.println("borrow - Borrow a book");
        System.out.println("renew - Renew a book");
        System.out.println("return - Return a book");
        System.out.println("loadgui - Load the GUI version of the app");
        System.out.println("help - Print help message");
        System.out.println("exit - Exit the program");
    }
    private static void listBooks() {
        library.getBooks().forEach((id, book) -> System.out.println(book));
    }

    private static void listPatrons() {
        library.getPatrons().forEach((id, patron) -> System.out.println(patron));
    }
    
    //A method to show specific books available in the database using the book id
    private static void showBookDetails(Scanner scanner) {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine().trim();
        Book book = library.getBooks().get(bookId);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }
    
    //A method to add books to the library database
    private static void addBook(Scanner scanner) {
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter book publisher: ");
        String publisher = scanner.nextLine().trim();
        System.out.print("Enter book publication year: ");
        int publicationYear = Integer.parseInt(scanner.nextLine().trim());

        Book newBook = new Book(id, title, author, publisher, publicationYear);
        library.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    // A method to add patrons to the library database
    private static void addPatron(Scanner scanner) {
        System.out.print("Enter patron ID: ");
        String patronId = scanner.nextLine().trim();
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine().trim();                 

        Patron newPatron = new Patron(patronId, patronName);
        library.addPatron(newPatron);
        System.out.println("Patron added successfully.");
    }
    
}
