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
    private void down(@PathVariable String id){
        List<Integer> integerList = ourWorkRepo.findAllIds();
        System.out.println(integerList);
        for(int i = 0; i < integerList.size(); i++){
            if(integerList.get(i).equals(Integer.parseInt(id))){
                OurWork findUp = ourWorkRepo.findById(integerList.get(i)).get();
                OurWork findDown = ourWorkRepo.findById(integerList.get(i+1)).get();

                String title = findUp.getTitle();
                String content = findUp.getContent();
                String fileBefore = findUp.getFileBefore();
                String fileAfter = findUp.getFileAfter();

                findUp.setTitle(findDown.getTitle());
                findUp.setContent(findDown.getContent());
                findUp.setFileBefore(findDown.getFileBefore());
                findUp.setFileAfter(findDown.getFileAfter());
                ourWorkRepo.save(findUp);

                findDown.setTitle(title);
                findDown.setContent(content);
                findDown.setFileBefore(fileBefore);
                findDown.setFileAfter(fileAfter);
                ourWorkRepo.save(findDown);
                break;
            }
        }
    }
    @PostMapping("/api/move/up/{id}")
    private void up(@PathVariable String id){
        List<Integer> integerList = ourWorkRepo.findAllIds();
        for(int i = 0; i < integerList.size(); i++){
            if(integerList.get(i).equals(Integer.parseInt(id))){
                OurWork findUp = ourWorkRepo.findById(integerList.get(i)).get();
                OurWork findDown = ourWorkRepo.findById(integerList.get(i-1)).get();
                String title = findUp.getTitle();
                String content = findUp.getContent();
                String fileBefore = findUp.getFileBefore();
                String fileAfter = findUp.getFileAfter();

                findUp.setTitle(findDown.getTitle());
                findUp.setContent(findDown.getContent());
                findUp.setFileBefore(findDown.getFileBefore());
                findUp.setFileAfter(findDown.getFileAfter());
                ourWorkRepo.save(findUp);

                findDown.setTitle(title);
                findDown.setContent(content);
                findDown.setFileBefore(fileBefore);
                findDown.setFileAfter(fileAfter);
                ourWorkRepo.save(findDown);
                break;
            }
        }
    }
}
