package a1_2001040023;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryManager {
    private List<Book> books;
    private List<LibraryTransaction> transactions;

    public LibraryManager() {
        books = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {

    }

    public List<LibraryTransaction> getCheckedOutBooks(Patron patron) {
        return null;
    }

    public void returnBook(LibraryTransaction transaction, Date returnDate) {
    }

    public List<LibraryTransaction> getOverdueBooks() {
        return null;
    }

    public void sort() {
    }
}
