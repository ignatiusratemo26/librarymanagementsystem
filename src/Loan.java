
import java.util.Date;

public class Loan {
    private Patron patron;
    private Book book;
    // Assuming loan date is not stored in the file
    private Date loanDate;

    public Loan(Patron patron, Book book, Date loanDate) {
        this.patron = patron;
        this.book = book;
        this.loanDate = loanDate;
    }

    // Getters and setters for all properties

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
}
