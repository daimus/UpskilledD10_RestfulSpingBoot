package id.daimus.restfulspringboot.controllers;

import id.daimus.restfulspringboot.models.Message;
import id.daimus.restfulspringboot.models.MessageBook;
import id.daimus.restfulspringboot.services.MessageBookService;
import id.daimus.restfulspringboot.utils.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/v1/message-books")
public class MessageBookController {
    @Autowired
    MessageBookService messageBookService;

    @GetMapping
    public ResponseEntity<Object> getMessageBooks(){
        log.info("GET /v1/message-books called");
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            List<MessageBook> messageBooks = messageBookService.getMessageBooks();
            responseHandler.setData(messageBooks.size() > 0 ? messageBooks : null);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error("GET /v1/message-book error: " + e.getMessage());
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getMessageBookById(@PathVariable Long id){
        log.info(String.format("GET /v1/message-book/%s called", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            Optional<MessageBook> messageBook = messageBookService.getMessageBookById(id);
            responseHandler.setData(messageBook.isPresent() ? messageBook : null);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("GET /v1/message-book/%s error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }

    @GetMapping(path = "/{id}/messages")
    public ResponseEntity<Object> getMessageBooksMessages(@PathVariable Long id){
        log.info(String.format("GET /v1/message-book/%s/messages called", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            Object messageBooksMessage = messageBookService.getMessageBooksMessage(id);
            responseHandler.setData(messageBooksMessage);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("GET /v1/message-book/%s/messages error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createMessageBook(@RequestBody MessageBook messageBookInput){
        log.info("POST /v1/message-book called");
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            MessageBook messageBook = messageBookService.createMessageBook(messageBookInput);
            responseHandler.setData(messageBook);
            responseHandler.setHttpCode(201);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("GET /v1/messages error: %s", e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<Object> updateMessageBook(@PathVariable Long id, @RequestBody MessageBook messageBookInput){
        log.info(String.format("PATCH /v1/message-book/%s called", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            MessageBook messageBook = messageBookService.updateMessageBook(id, messageBookInput);
            responseHandler.setData(messageBook);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("PATCH /v1/message-book/%s error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteMessageBook(@PathVariable Long id){
        log.info(String.format("GET /v1/message-book/%s called", id));
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            messageBookService.deleteMessageBook(id);
            responseHandler.setHttpCode(204);
            return responseHandler.getResponse();
        } catch (Exception e){
            log.error(String.format("DELETE /v1/message-book/%s error: %s", id, e));
            responseHandler.setErrors(e.getMessage());
            return responseHandler.getResponse();
        }
    }
}
