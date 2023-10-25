package a1_2001040023;
import common.Genre;
import common.PatronType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LibraryManProg {
    private Date[] checkoutDate = new Date[]{
            new Date(2023 - 1900, Calendar.MARCH, 25),
            new Date(2023 - 1900, Calendar.MAY, 8),
            new Date(2023 - 1900, Calendar.JUNE, 1),
            new Date(2023 - 1900, Calendar.JUNE, 25),
            new Date(2023 - 1900, Calendar.AUGUST, 10)
    };

    private Date[] dueDate = new Date[]{
            new Date(2023 - 1900, Calendar.APRIL, 25),
            new Date(2023 - 1900, Calendar.MAY, 10),
            new Date(2023 - 1900, Calendar.JUNE, 25),
            new Date(2023 - 1900, Calendar.JULY, 25),
            new Date(2023 - 1900, Calendar.SEPTEMBER, 20)
    };

    public static void main(String[] args) throws ParseException {
        LibraryManager libraryManager = new LibraryManager();

        // Initialize at least 10 books in the library collection.
        Book[] books = new Book[10];
        books[0] = new Book("The Catcher in the Rye", "J.D. Salinger", Genre.FICTION, 1951, 5);
        books[1] = new Book("To Kill a Mockingbird", "Harper Lee", Genre.FICTION, 1960, 3);
        books[2] = new Book("1984", "George Orwell", Genre.SCIENCE_FICTION, 1949, 2);
        books[3] = new Book("Pride and Prejudice", "Jane Austen", Genre.ROMANCE, 1813, 4);
        books[4] = new Book("The Hobbit", "J.R.R. Tolkien", Genre.FANTASY, 1937, 5);
        books[5] = new Book("The Da Vinci Code", "Dan Brown", Genre.MYSTERY, 2003, 6);
        books[6] = new Book("Brave New World", "Aldous Huxley", Genre.SCIENCE_FICTION, 1932, 2);
        books[7] = new Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION, 1925, 3);
        books[8] = new Book("The Alchemist", "Paulo Coelho", Genre.ADVENTURE, 1988, 4);
        books[9] = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", Genre.FANTASY, 1997, 5);

        for (int i = 0; i < books.length; i++) {
            libraryManager.addBook(books[i]);
        }

        // Initialize at least 3 patrons involving both regular and premium patrons.
        Patron patron1 = new Patron("Alice Johnson", parseDate("1990-01-15"), "alice@example.com", "555-1234", PatronType.REGULAR);
        Patron patron2 = new Patron("Bob Smith", parseDate("1985-08-30"), "bob@example.com", "555-5678", PatronType.PREMIUM);
        Patron patron3 = new Patron("Charlie Brown", parseDate("1995-03-22"), "charlie@example.com", "555-9876", PatronType.REGULAR);

        // Initialize and use to create 5 book transactions
        libraryManager.checkoutBook(patron1, books[0], parseDate("2023-03-25"), parseDate("2023-04-25"));
        libraryManager.checkoutBook(patron2, books[1], parseDate("2023-05-08"), parseDate("2023-05-10"));
        libraryManager.checkoutBook(patron3, books[2], parseDate("2023-06-01"), parseDate("2023-06-25"));
        libraryManager.checkoutBook(patron1, books[3], parseDate("2023-06-25"), parseDate("2023-07-25"));
        libraryManager.checkoutBook(patron2, books[4], parseDate("2023-08-10"), parseDate("2023-09-20"));

        // Print a list of currently checked-out books
        System.out.println("Checked-Out Books:");
        List<LibraryTransaction> checkedOutBooks = libraryManager.getCheckedOutBooks(patron1);
        for (LibraryTransaction transaction : checkedOutBooks) {
            System.out.println(transaction.getDescription());
        }

        // Patron returns a book
        libraryManager.returnBook(checkedOutBooks.get(0), parseDate("2023-05-27"));

        // Print a list of the overdue books that are not returned yet
        System.out.println("\nOverdue Books:");
        List<LibraryTransaction> overdueBooks = libraryManager.getOverdueBooks();
        for (LibraryTransaction transaction : overdueBooks) {
            System.out.println(transaction.getDescription());
        }

        // Sort transactions by patron ID
        libraryManager.sort();
    }

    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateStr);
    }

}
