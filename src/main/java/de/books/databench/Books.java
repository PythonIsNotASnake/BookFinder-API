package de.books.databench;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> bookList;

    public Books(){
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        if(bookList == null) {
            bookList = new ArrayList<>();
        }
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
