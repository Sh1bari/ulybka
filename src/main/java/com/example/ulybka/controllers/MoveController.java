package com.example.ulybka.controllers;

import com.example.ulybka.entities.OurWork;
import com.example.ulybka.repo.OurWorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MoveController {
    @Autowired
    private OurWorkRepo ourWorkRepo;

    @PostMapping("/api/move/down/{id}")
    private void down(@RequestParam String id){
        List<Integer> integerList = ourWorkRepo.findAllIds();
        for(int i = 0; i < integerList.size(); i++){
            if(integerList.get(i).equals(Integer.parseInt(id))){
                OurWork findUp = ourWorkRepo.findById(integerList.get(i)).get();
                OurWork findDown = ourWorkRepo.findById(integerList.get(i+1)).get();
                int var = findUp.getId();
                findUp.setId(findDown.getId());
                findDown.setId(var);
                ourWorkRepo.save(findUp);
                ourWorkRepo.save(findDown);
                break;
            }
        }
    }
    @PostMapping("/api/move/up/{id}")
    private void up(@RequestParam String id){
        List<Integer> integerList = ourWorkRepo.findAllIds();
        for(int i = 0; i < integerList.size(); i++){
            if(integerList.get(i).equals(Integer.parseInt(id))){
                OurWork findUp = ourWorkRepo.findById(integerList.get(i)).get();
                OurWork findDown = ourWorkRepo.findById(integerList.get(i-1)).get();
                int var = findUp.getId();
                findUp.setId(findDown.getId());
                findDown.setId(var);
                ourWorkRepo.save(findUp);
                ourWorkRepo.save(findDown);
                break;
            }
        }
    }
}
