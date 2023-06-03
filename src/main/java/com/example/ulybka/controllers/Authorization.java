package com.example.ulybka.controllers;

import com.example.ulybka.models.Admin;
import com.example.ulybka.models.Answer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Authorization {

    @PostMapping("/api/checkAuth")
    private Answer check(@RequestBody Admin admin){
        Answer answer = new Answer("denied");
        if(admin.getLogin().equals("ElenaTac") && admin.getPassword().equals("admin123")){
            answer.setStatus("done");
        }
        return answer;
    }
}
