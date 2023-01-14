package id.daimus.restfulspringboot.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1")
public class MessageController {
    @GetMapping(path = "/messages")
    public ResponseEntity<String> getMessage(){
        log.info("GET /v1/messages called");
        return ResponseEntity.ok("Hello World");
    }
    @PostMapping(path = "/messages")
    public ResponseEntity<String> postMessage(){
        log.info("POST /v1/messages called");
        return ResponseEntity.ok("Hello World");
    }
    @DeleteMapping(path = "/messages")
    public ResponseEntity<String> deleteMessage(){
        log.info("DELETE /v1/messages called");
        return ResponseEntity.ok("Hello World");
    }
}
