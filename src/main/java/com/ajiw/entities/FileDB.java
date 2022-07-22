package com.ajiw.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "files")
@Getter
@Setter
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    @JsonIgnore
    @OneToOne(mappedBy = "photo")
    Declaration declaration;

    private String path;

    public FileDB() {
    }
    public FileDB(String name, String type) {
        this.name = name;
        this.type = type;

    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}