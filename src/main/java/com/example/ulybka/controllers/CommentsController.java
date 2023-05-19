package com.example.ulybka.controllers;

import com.example.ulybka.entities.Comments;
import com.example.ulybka.models.Answer;
import com.example.ulybka.repo.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentsController {
    @Autowired
    private CommentsRepo commentsRepo;

    @PostMapping("/send")
    private Answer send(@RequestBody Comments comments){
        Answer answer = new Answer();
        answer.setStatus("done");
        comments.setStatus("pending");
        commentsRepo.save(comments);
        return answer;
    }

    @GetMapping("/getAllForUser")
    private List<Comments> getForUsers(){
        List<Comments> commentsList = commentsRepo.findAllByNameContainingOrderByDateDesc("");
        List<Comments> commentsSend = new ArrayList<>();
        for (Comments o : commentsList){
            if(o.getStatus().equals("published")) {
                o.setNumber(null);
                o.setStatus(null);
                commentsSend.add(o);
            }
        }
        return commentsSend;
    }

    @GetMapping("/getAllForAdmin")
    private List<Comments> getForAdmin(){
        return commentsRepo.findAllByNameContainingOrderByDateDesc("");
    }
    @PostMapping("/publish/{id}")
    private Answer publish(@PathVariable Integer id){
        Answer answer = new Answer();
        answer.setStatus("done");
        Optional<Comments> comments1 = commentsRepo.findById(id);
        Comments finalComment = comments1.get();
        finalComment.setStatus("published");
        commentsRepo.save(finalComment);
        return answer;
    }
}
