package com.ajiw.Controllers;

import com.ajiw.entities.Comment;
import com.ajiw.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/{id}")
    public List<Comment> findCommentsByDeclarationId(@PathVariable Long id) {
        return commentService.findCommentsByDeclarationId(id);
    }
    @GetMapping("/newComment/{idDeclaration}/{email}/{commentText}")
    public Optional<?> saveComment(@PathVariable  Long idDeclaration,@PathVariable String email,@PathVariable String commentText) {
        return commentService.saveComment(idDeclaration, email, commentText);
    }
    @DeleteMapping("/delete/{id}")
    public Optional<?> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
