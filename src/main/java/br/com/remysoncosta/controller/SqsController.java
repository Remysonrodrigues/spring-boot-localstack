package br.com.remysoncosta.controller;

import br.com.remysoncosta.service.SqsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SqsController {

    @Autowired
    private SqsMessageService sqsMessageService;

    @GetMapping("/sqs/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
        sqsMessageService.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}
