package com.example.sellions.controller;

import com.example.sellions.Exceptions.SupportingRuntimeError;
import com.example.sellions.dao.entity.Comment;
import com.example.sellions.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.sellions.Exceptions.ExceptionMessagesLibrary.YOU_SHOULD_POINT_NAME;

@RestController
@RequestMapping("/sellionsComment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/addComment/{index}")
    public void addComment(@PathVariable long index, @RequestBody Comment comment){
        try{
            commentService.save(index,comment);
        }catch (RuntimeException ex){
            throw new SupportingRuntimeError(YOU_SHOULD_POINT_NAME);
        }
    }

}
