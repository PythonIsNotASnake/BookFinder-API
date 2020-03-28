package de.books.webservice;

import de.books.databench.Book;
import de.books.databench.Books;
import de.books.databench.Databench;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://192.168.178.40", maxAge = 3600)
@CrossOrigin(origins = "http://192.168.178.51", maxAge = 3600)
@RestController
@RequestMapping(path = "/books")
public class BookController {

    //@Autowired
    //private Databench bench;

    @CrossOrigin
    @GetMapping(path = "/", produces = "application/json")
    public Books getBooks() {
        Databench bench = new Databench();
        Books books = bench.getAllEntries();
        bench.closeConnection();
        return books;
    }

    @CrossOrigin
    @RequestMapping(value = "/{search}/", method = RequestMethod.GET)
    public Books getBook(@PathVariable String search) {
        Databench bench = new Databench();
        Books books = bench.search(search);
        bench.closeConnection();
        return books;
    }

    @CrossOrigin
    @RequestMapping(value = "/{isbn}/", method = RequestMethod.DELETE)
    public boolean deleteBook(@PathVariable String isbn) {
        Databench bench = new Databench();
        boolean b = bench.deleteEntry(isbn);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{isbn}/{title}/{autor}/{reihe}/{place}/{release}/", method = RequestMethod.POST)
    public boolean createBook(@PathVariable String isbn, @PathVariable String title, @PathVariable String autor, @PathVariable String reihe, @PathVariable String place, @PathVariable String release) {
        Databench bench = new Databench();
        boolean b = bench.addEntry(isbn, title, autor, reihe, place, release);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{oldisbn}/isbn/{newisbn}/", method = RequestMethod.PUT)
    public boolean updateISBN(@PathVariable String oldisbn, @PathVariable String newisbn){
        Databench bench = new Databench();
        boolean b = bench.updateISBN(oldisbn, newisbn);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{isbn}/title/{title}/", method = RequestMethod.PUT)
    public boolean updateTitle(@PathVariable String isbn, @PathVariable String title){
        Databench bench = new Databench();
        boolean b = bench.updateTitle(isbn, title);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{isbn}/autor/{autor}/", method = RequestMethod.PUT)
    public boolean updateAutor(@PathVariable String isbn, @PathVariable String autor){
        Databench bench = new Databench();
        boolean b = bench.updateAutor(isbn, autor);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{isbn}/reihe/{reihe}/", method = RequestMethod.PUT)
    public boolean updateReihe(@PathVariable String isbn, @PathVariable String reihe){
        Databench bench = new Databench();
        boolean b = bench.updateReihe(isbn, reihe);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{isbn}/place/{place}/", method = RequestMethod.PUT)
    public boolean updatePlace(@PathVariable String isbn, @PathVariable String place){
        Databench bench = new Databench();
        boolean b = bench.updatePlace(isbn, place);
        bench.closeConnection();
        return b;
    }

    @CrossOrigin
    @RequestMapping(path = "/{isbn}/release/{release}/", method = RequestMethod.PUT)
    public boolean updateRelease(@PathVariable String isbn, @PathVariable String release){
        Databench bench = new Databench();
        boolean b = bench.updateRelease(isbn, release);
        bench.closeConnection();
        return b;
    }

}
