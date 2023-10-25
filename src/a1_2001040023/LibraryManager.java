package a1_2001040023;

import common.DateUtils;
import common.PatronType;

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
        books.add(book);
    }

    public void checkoutBook(Patron patron, Book book, Date checkoutDate, Date dueDate) {
        List<LibraryTransaction> checkedOutBooks = getCheckedOutBooks(patron);

        if ((patron.getPatronType() == PatronType.REGULAR && checkedOutBooks.size() < 3)
                || (patron.getPatronType() == PatronType.PREMIUM && checkedOutBooks.size() < 5)) {
            LibraryTransaction transaction = new LibraryTransaction(patron, book, checkoutDate, dueDate);
            transactions.add(transaction);
            book.setNumCopiesAvailable(book.getNumCopiesAvailable() - 1);
        } else {
            System.out.println("Patron has reached their checkout limit.");
        }
    }

    public List<LibraryTransaction> getCheckedOutBooks(Patron patron) {
        List<LibraryTransaction> checkedOutBooks = new ArrayList<>();
        for (LibraryTransaction transaction : transactions) {
            if (transaction.getPatron().equals(patron) && transaction.getReturnDate() == null) {
                checkedOutBooks.add(transaction);
            }
        }
        return checkedOutBooks;
    }


    public void returnBook(LibraryTransaction transaction, Date returnDate) {
        transaction.setReturnDate(returnDate);
        Book book = transaction.getBook();
        book.setNumCopiesAvailable(book.getNumCopiesAvailable() + 1);
        System.out.println("Book returned successfully.");
    }

    public List<LibraryTransaction> getOverdueBooks() {
        List<LibraryTransaction> overdueBooks = new ArrayList<>();
        DateUtils dateUtils = new DateUtils();
        Date currentDate = dateUtils.getCurrentDate();

        for (LibraryTransaction transaction : transactions) {
            if (transaction.getReturnDate() == null && currentDate.after(transaction.getDueDate())) {
                overdueBooks.add(transaction);
            }
        }
        return overdueBooks;
    }

    public void sort() {
        transactions.sort((t1, t2) -> t1.getPatron().getPatronID().compareTo(t2.getPatron().getPatronID()));
    }
}
