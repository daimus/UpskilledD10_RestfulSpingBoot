package id.daimus.restfulspringboot.controllers;

import id.daimus.restfulspringboot.models.Message;
import id.daimus.restfulspringboot.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/v1/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping
    public ResponseEntity<List<Message>> getMessages(){
        log.info("GET /v1/messages called");
        List<Message> messages = messageService.getMessages();
        if (messages.size() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(messages);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Message>> getMessageById(@PathVariable Long id){
        log.info("GET /v1/messages/{id} called with id " + String.valueOf(id));
        Optional<Message> message = messageService.getMessageById(id);
        if (message.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(message);
    }
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message messageInput){
        log.info("POST /v1/messages called");
        Message message = messageService.createMessage(messageInput);
        return ResponseEntity.ok(message);
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message messageInput){
        log.info("PATCH /v1/messages called");
        Message message = messageService.updateMessage(id, messageInput);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Objects> deleteMessage(@PathVariable Long id){
        log.info("DELETE /v1/messages called");
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
