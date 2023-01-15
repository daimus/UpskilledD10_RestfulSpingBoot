package id.daimus.restfulspringboot.repositories;

import id.daimus.restfulspringboot.models.MessageBook;
import org.springframework.data.repository.CrudRepository;

public interface MessageBookRepository extends CrudRepository<MessageBook, Long> {
}
