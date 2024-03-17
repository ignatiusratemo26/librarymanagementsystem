import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    
    
    private static final String BOOKS_FILE_PATH = "resources/data/books.txt";
    private static final String PATRONS_FILE_PATH = "resources/data/patrons.txt";
    private static final String LOANS_FILE_PATH = "resources/data/loans.txt";
    
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Patron> patrons = new HashMap<>();
    private List<Loan> loans = new ArrayList<>();
    
    public Library() {
        loadBooks();
        loadPatrons();
        loadLoans();
    }
    
    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, Patron> getPatrons() {
        return patrons;
    }
    
    public void addBook(Book book) {
        books.put(book.getId(), book);
        saveBooks();
    }

    // Method to add a patron
    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
        savePatrons();
    }

    // Other methods for interacting with books, patrons, and loans

    private void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE_PATH))) {
            for (Book book : books.values()) {
                writer.write(book.getId() + "::" + book.getTitle() + "::" + book.getAuthor() + "::" +
                        book.getPublisher() + "::" + book.getPublicationYear());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePatrons() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATRONS_FILE_PATH))) {
            for (Patron patron : patrons.values()) {
                writer.write(patron.getId() + "::" + patron.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Methods for adding books, adding patrons, borrowing, renewing, returning books, etc.
    private void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("::");
                String id = parts[0];
                String title = parts[1];
                String author = parts[2];
                String publisher = parts[3];
                int publicationYear = Integer.parseInt(parts[4]);
                Book book = new Book(id, title, author, publisher, publicationYear);
                books.put(id, book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPatrons() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATRONS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("::");
                String id = parts[0];
                String name = parts[1];
                Patron patron = new Patron(id, name);
                patrons.put(id, patron);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLoans() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOANS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("::");
                String patronId = parts[0];
                String bookId = parts[1];
                // Assuming the loan date is not stored in the file
                Loan loan = new Loan(patrons.get(patronId), books.get(bookId), null);
                loans.add(loan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methods to write changes back to files would also be needed
}
 