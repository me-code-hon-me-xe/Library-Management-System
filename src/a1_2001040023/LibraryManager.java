package a1_2001040023;

import java.util.Date;
import java.util.List;

public class LibraryManager {
    public static List<Book> books;
    public static List<LibraryTransaction> transactions;

    public static void addBook(Book book){}

    public static List<LibraryTransaction> getCheckedOutBooks(Patron patron){
        return null;
    }

    public static void returnBook(LibraryTransaction transaction, Date returnDate){}

    public static List<LibraryTransaction> getOverdueBooks(){
        return null;
    }

    public static void sort(){}
}
