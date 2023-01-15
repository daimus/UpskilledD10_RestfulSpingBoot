package id.daimus.restfulspringboot.repositories;

import id.daimus.restfulspringboot.models.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("FROM Message m WHERE m.messageBookId = :messageBookId")
    List<Message> getMessagesByMessageBook(@Param("messageBookId") String id);
}
