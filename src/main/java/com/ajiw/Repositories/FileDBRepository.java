package com.ajiw.Repositories;
import com.ajiw.entities.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    FileDB findByName(String name);
}