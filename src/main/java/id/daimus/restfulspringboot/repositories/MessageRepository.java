package id.daimus.restfulspringboot.repositories;

import id.daimus.restfulspringboot.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
