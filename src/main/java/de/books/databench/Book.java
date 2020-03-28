package de.books.databench;

public class Book {

    private String isbn;
    private String title;
    private String autor;
    private String reihe;
    private String place;
    private String release;

    public Book(String isbn, String title, String autor, String reihe, String place, String release) {
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
        this.reihe = reihe;
        this.place = place;
        this.release = release;
    }

    public Book() {

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getReihe() {
        return reihe;
    }

    public void setReihe(String reihe) {
        this.reihe = reihe;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "Book [ISBN=" + isbn + ", Titel=" + title + ", Autor=" + autor + ", Reihe=" + reihe + ", Lagerort=" + place + ", Erscheinungsjahr=" + release + "]";
    }
}
