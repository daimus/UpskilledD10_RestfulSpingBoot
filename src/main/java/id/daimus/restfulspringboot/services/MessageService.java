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
        Optional<Message> message = messageRepository.findById(id);
        if (message.isPresent()){
            if (message.get().getIsAnonymous()){
                message.get().setFrom("*****");
            }
        }
        return message;
    }
    public List<Message> getMessages(){
        List<Message> messages = (List<Message>) messageRepository.findAll();
        for (Message message : messages) {
            if (message.getIsAnonymous()){
                message.setFrom("*****");
            }
        }
        return messages;
    }
    public List<Message> getMessagesByMessageBookId(Long messageBookId){
        List<Message> messages = messageRepository.getMessagesByMessageBook(String.valueOf(messageBookId));
        for (Message message : messages) {
            if (message.getIsAnonymous()){
                message.setFrom("*****");
            }
        }
        return messages;
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
