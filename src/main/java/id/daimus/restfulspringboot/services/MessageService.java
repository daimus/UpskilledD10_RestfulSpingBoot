package id.daimus.restfulspringboot.services;

import id.daimus.restfulspringboot.models.Message;
import id.daimus.restfulspringboot.repositories.MessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public Optional<Message> getMessageById(Long id){
        return messageRepository.findById(id);
    }
    public List<Message> getMessages(){
        return (List<Message>) messageRepository.findAll();
    }
    public Message createMessage(Message message){
        return messageRepository.save(message);
    }
    public Message updateMessage(Long id, Message message){
        message.setId(id);
        return messageRepository.save(message);
    }
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }
}
