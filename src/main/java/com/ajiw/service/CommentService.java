package com.ajiw.service;

import com.ajiw.Repositories.CommentRepos;
import com.ajiw.Repositories.DeclarationRepository;
import com.ajiw.Repositories.UserRespository;
import com.ajiw.entities.Comment;
import com.ajiw.entities.Declaration;
import com.ajiw.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepos commentRepos;
    @Autowired
    UserRespository userRespository;
    @Autowired
    DeclarationRepository declarationRepository;
    public List<Comment> findCommentsByUserId(int id) {
        return commentRepos.findCommentsByUserId(id);
    }

    public List<Comment> findCommentsByDeclarationId(Long id) {
        return commentRepos.findCommentsByDeclarationId(id);
    }
    public Optional<?> saveComment(Long idDeclaration ,String email,String commentText){
        Declaration  declaration = declarationRepository.findDeclarationById(idDeclaration);
        User user=userRespository.findByEmail(email);
        System.out.println("User" +user.getEmail());
        System.out.println("declaration" +declaration.getTitle());
        if(user!=null && declaration!=null){
            Comment comment=new Comment();
            comment.setComment(commentText);
            comment.setUser(user);
            comment.setDeclaration(declaration);
            LocalDateTime date = LocalDateTime.now();
            Timestamp date2= Timestamp.valueOf(date);
            comment.setDate(date2);
            commentRepos.save(comment);
            return Optional.of(1);

        }else{
            return  Optional.of(-1);
        }
    }
    @Transactional
  public   Optional<?> deleteComment(Long id){
        return Optional.of(commentRepos.deleteCommentByidComment(id));
  }
}
