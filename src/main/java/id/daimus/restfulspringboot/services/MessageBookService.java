package id.daimus.restfulspringboot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.daimus.restfulspringboot.models.Message;
import id.daimus.restfulspringboot.models.MessageBook;
import id.daimus.restfulspringboot.repositories.MessageBookRepository;
import id.daimus.restfulspringboot.repositories.MessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class MessageBookService {
    @Autowired
    MessageBookRepository messageBookRepository;
    @Autowired
    MessageService messageService;

    public Optional<MessageBook> getMessageBookById(Long id) {
        return messageBookRepository.findById(id);
    }

    public List<MessageBook> getMessageBooks() {
        return (List<MessageBook>) messageBookRepository.findAll();
    }

    public Object getMessageBooksMessage(Long id){
        Optional<MessageBook> messageBook = this.getMessageBookById(id);
        if (messageBook.isPresent()){
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.convertValue(messageBook.get(), Map.class);
            List<Message> messages = messageService.getMessagesByMessageBookId(id);
            map.put("messages", messages);
            return map;
        }
        return null;
    }

    public MessageBook createMessageBook(MessageBook message) {
        return messageBookRepository.save(message);
    }

    public MessageBook updateMessageBook(Long id, MessageBook message) {
        message.setId(id);
        return messageBookRepository.save(message);
    }

    public void deleteMessageBook(Long id) {
        messageBookRepository.deleteById(id);
    }
}
