package org.frakin.Application.Controller;


import org.frakin.Application.Service.MessageService_1;
import org.frakin.Application.Service.MessageService_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService_1 messageService_1;
    @Autowired
    private MessageService_2 messageService_2;

    @PostMapping
    public ResponseEntity<String> exampleMethod(@RequestBody String message) {
        messageService_2.message(message);
        return ResponseEntity.ok(messageService_1.giveMessage(message));
    }
}
