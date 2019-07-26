package springboot.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springboot.mongodb.model.Book;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
