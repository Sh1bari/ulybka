package com.example.ulybka.controllers;

import com.example.ulybka.entities.CallBack;
import com.example.ulybka.models.Answer;
import com.example.ulybka.repo.CallBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/callback")
@CrossOrigin
public class CallBackController {

    @GetMapping("/hi")
    private String hi(){
        return "hi";
    }
    @Autowired
    private CallBackRepo callBackRepo;

    @PostMapping("/send")
    private Answer send(@RequestBody CallBack callBack){
        callBackRepo.save(callBack);
        return new Answer("done");
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
