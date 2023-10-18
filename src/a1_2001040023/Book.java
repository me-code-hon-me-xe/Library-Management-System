package a1_2001040023;

import common.DateUtils;
import common.Genre;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private int publicationYear;
    private int numCopiesAvailable;

    public Book(String isbn, String title, String author, Genre genre, int publicationYear, int numCopiesAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.numCopiesAvailable = numCopiesAvailable;
    }

    public void generateISBN(){ // Extract author's initials and genre code
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
    public int  getNumCopiesAvailable(){
        return numCopiesAvailable;
    }
}
