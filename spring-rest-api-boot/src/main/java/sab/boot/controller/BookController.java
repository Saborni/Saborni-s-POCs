package sab.boot.controller;

import org.springframework.web.bind.annotation.*;
import sab.boot.model.Book;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BookController {

    private List<Book> bookList = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        book.setBookID(id.incrementAndGet());
        bookList.add(book);
        System.out.println(book);
        return book;
    }

    @GetMapping("/bookList")
    public List<Book> getBookList(){
        System.out.println(bookList);
        return bookList;
    }

    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable("id") long bookId){
        for (Book book:bookList) {
            if(bookId == book.getBookID()){
                System.out.println("Found");
                return book;
            }
        }
        System.out.println("not found");
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public List<Book> deleteByID(@PathVariable("id") long bookId){
        for (Book book:bookList) {
            if(bookId == book.getBookID()){
                bookList.remove(bookId);
                System.out.println("deleted");
                return bookList;
            }
        }
        System.out.println("nothing to delete");
        return null;
    }




}
