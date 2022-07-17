package com.ajiw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComment;

    @ManyToOne
    private User user;
    private String comment;
    private Timestamp date;
    @JsonIgnore
    @ManyToOne
    Declaration declaration;

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", user=" + user.getPrenom()+" "+user.getNom()+
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", declaration=" + declaration.getTitle()+
                '}';
    }
}
