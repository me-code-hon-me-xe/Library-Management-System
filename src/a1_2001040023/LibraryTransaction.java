package a1_2001040023;

import common.Genre;
import common.PatronType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class LibraryTransaction {

    private Patron patron;
    private Book book;
    private Date checkoutDate;
    private Date dueDate;
    private Date returnDate;
    private double fineAmount;

    public LibraryTransaction(Patron patron, Book book, Date checkoutDate, Date dueDate) {
        this.patron = patron;
        this.book = book;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public  void calculateFine(){
        Date dueDate = new Date(2023 - 1900, Calendar.APRIL, 25);
        Date returnDate = new Date(2023 - 1900, Calendar.MAY, 27);
        int overdueDays = (int)(returnDate.getTime()-dueDate.getTime())/(24*60*60*1000);
        fineAmount = 0;
        System.out.println(overdueDays);
        if(overdueDays <= 7 && overdueDays >= 1){
            fineAmount = overdueDays*1.00;
        }else if(overdueDays >= 8 && overdueDays <= 14){
            fineAmount = overdueDays * 2.00;
        } else {
            fineAmount = overdueDays * 3.00;
        }
    }
    public  void getDescription(){}

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", Genre.FICTION, 1951, 5);
        Patron patron1 = new Patron("Alice Johnson", dateFormat.parse("1990-01-15"), "alice@example.com", "555-1234", PatronType.REGULAR);
        Date checkoutDate = new Date(2023 - 1900, Calendar.MARCH, 25);
        Date dueDate = new Date(2023 - 1900, Calendar.APRIL, 25);
        Date returnDate = new Date(2023 - 1900, Calendar.MAY, 27);
        LibraryTransaction libraryTransaction1 = new LibraryTransaction(patron1,book1,checkoutDate,dueDate);
        libraryTransaction1.calculateFine();

    }
}
