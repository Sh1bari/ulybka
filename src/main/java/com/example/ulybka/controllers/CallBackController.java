package com.example.ulybka.controllers;

import com.example.ulybka.entities.CallBack;
import com.example.ulybka.models.Answer;
import com.example.ulybka.repo.CallBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/callback")
public class CallBackController {

    @GetMapping("/hi")
    private String hi(){
        return "hi";
    }
    @Autowired
    private CallBackRepo callBackRepo;

    @PostMapping("/send")
    private void send(@RequestBody CallBack callBack){
        callBack.setStatus("pending");
        callBackRepo.save(callBack);
    }

    @GetMapping("/get")
    private List<CallBack> get(){
        return callBackRepo.findAllByNumberContainingOrderByDateDesc("");
    }

    @PostMapping("/delete")
    private Answer delete(@RequestBody CallBack callBack){
        Answer answer = new Answer();
        callBackRepo.deleteCallBack(callBack.getId());
        answer.setStatus("done");
        return answer;
    }

}
