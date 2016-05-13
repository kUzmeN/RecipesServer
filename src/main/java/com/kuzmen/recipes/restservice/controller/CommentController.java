package com.kuzmen.recipes.restservice.controller;

import com.kuzmen.recipes.restservice.entity.Comment;
import com.kuzmen.recipes.restservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(value = "/comments")
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getComments() {
        List comments = commentService.getAll();
        return comments;

    }

    @RequestMapping(value = "/byrecipe/{id}", method = RequestMethod.GET )
    @ResponseBody
    public List<Comment> getCommentsByRecipe(@PathVariable("id") int id) {
        List comments = commentService.findByRecipe(id);
        return comments;

    }


}
