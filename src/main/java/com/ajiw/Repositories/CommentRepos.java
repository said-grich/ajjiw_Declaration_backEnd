package com.ajiw.Repositories;

import com.ajiw.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepos extends JpaRepository<Comment,Long> {
    List<Comment> findCommentsByUserId(int id);
    List<Comment> findCommentsByDeclarationId(Long id);
    int deleteCommentByidComment(Long id);

}
