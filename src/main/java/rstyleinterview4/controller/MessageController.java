package rstyleinterview4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rstyleinterview4.model.Message;
import rstyleinterview4.service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;


    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;

    }

    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Message message){
        messageService.create(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
