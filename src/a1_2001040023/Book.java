package a1_2001040023;
/*
* Hoi thay ve format cua author - > affect isbn format
*
*
* */
import common.Genre;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int publicationYear;
    private int numCopiesAvailable;


    public static void main(String[] args) {
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

        for(int i = 0, length = books.length; i < length; i++){
            System.out.println(books[i].isbn);
        }

    }

    public Book(String title, String author, Genre genre, int publicationYear, int numCopiesAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.numCopiesAvailable = numCopiesAvailable;

        // Automatically generate ISBN when creating a new book
        this.isbn = generateISBN();
    }

    public String generateISBN(){
        String[] authorNameArray = author.split(" ");
        String authorName = "";
        for (int i = 0, length = authorNameArray.length; i < length; i++){
            authorName = authorName + authorNameArray[i].toUpperCase().substring(0,1);
        }
        String genreOrder = String.format("%02d", genre.ordinal() + 1);
        String isbn = authorName.toUpperCase() + "-" + genreOrder + "-" + publicationYear;
        return isbn;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setNumCopiesAvailable(int numCopiesAvailable) {
        this.numCopiesAvailable = numCopiesAvailable;
    }

    public int getNumCopiesAvailable() {
        return numCopiesAvailable;
    }
}
