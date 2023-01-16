package id.daimus.restfulspringboot.controllers;

import id.daimus.restfulspringboot.models.Message;
import id.daimus.restfulspringboot.services.MessageService;
import id.daimus.restfulspringboot.utils.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping
    public ResponseEntity<Object> getMessages(){
        log.info("GET /v1/messages called");
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            List<Message> messages = messageService.getMessages();
            responseHandler.setData(messages.size() > 0 ? messages : null);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("GET /v1/messages error: %s", e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getMessageById(@PathVariable Long id){
        log.info(String.format("GET /v1/messages/%s ", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            Optional<Message> message = messageService.getMessageById(id);
            responseHandler.setData(message.isPresent() ? message : null);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("GET /v1/messages/%s error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }
    @PostMapping
    public ResponseEntity<Object> createMessage(@RequestBody Message messageInput){
        log.info("POST /v1/messages called");
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            Message message = messageService.createMessage(messageInput);
            responseHandler.setHttpCode(201);
            responseHandler.setData(message);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("POST /v1/messages error: %s", e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateMessage(@PathVariable Long id, @RequestBody Message messageInput){
        log.info(String.format("PATCH /v1/messages/%s called", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            Message message = messageService.updateMessage(id, messageInput);
            responseHandler.setData(message);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("PATCH /v1/messages/%s error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteMessage(@PathVariable Long id){
        log.info(String.format("DELETE /v1/messages/%s called", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            messageService.deleteMessage(id);
            responseHandler.setHttpCode(204);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("DELETE /v1/messages/%s error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }
}
