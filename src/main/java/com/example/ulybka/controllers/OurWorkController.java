package com.example.ulybka.controllers;

import com.example.ulybka.entities.OurWork;
import com.example.ulybka.repo.OurWorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/work")
public class OurWorkController {
    @Autowired
    private OurWorkRepo ourWorkRepo;

    @PostMapping("/post")
    public ResponseEntity<String> upload(@RequestBody OurWork ourWorkReq) {
        try {
            OurWork ourWork = new OurWork();
            ourWork.setFileBefore(ourWorkReq.getFileBefore());
            ourWork.setFileAfter(ourWorkReq.getFileAfter());
            ourWork.setTitle(ourWorkReq.getTitle());
            ourWork.setContent(ourWorkReq.getContent());
            ourWorkRepo.save(ourWork);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Files uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload the file");
        }
    }

    @GetMapping("/get")
    private List<OurWork> ourWorkList(){
        List<OurWork> result = new ArrayList<>();
        ourWorkRepo.findAll().forEach(result::add);
        return result;
    }

    @PostMapping("/delete/{id}")
    private ResponseEntity<String> deleteWork(@PathVariable String id){
        ourWorkRepo.deleteWork(Integer.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
