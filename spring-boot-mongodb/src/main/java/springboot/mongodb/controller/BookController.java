package springboot.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.mongodb.model.Book;
import springboot.mongodb.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Added Book with id : "+book.getBookId();
    }

    @GetMapping("/findBooks")
    public List<Book> findAllBook(){
        return bookRepository.findAll();
    }

    @GetMapping("/findBook/{id}")
    public Optional<Book> findBookById(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "Book with id:"+id+" deleted successfully!";
    }
}
