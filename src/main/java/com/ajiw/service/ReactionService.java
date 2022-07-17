package com.ajiw.service;

import com.ajiw.Repositories.DeclarationRepository;
import com.ajiw.Repositories.ReactionRepository;
import com.ajiw.Repositories.UserRespository;
import com.ajiw.entities.Declaration;
import com.ajiw.entities.Reaction;
import com.ajiw.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReactionService {
    @Autowired
    ReactionRepository reactionRepository;
    @Autowired
    DeclarationRepository declarationRepository;
    @Autowired
    UserRespository userRespository;

    public Optional<?> saveReaction(int userId,Long idDeclaration,int reaction){

        User user= userRespository.findById(userId);
        Declaration declaration=declarationRepository.findDeclarationById(idDeclaration);
        if(user!=null && declaration!=null){
            Reaction reaction1=new Reaction();
            reaction1.setReaction(reaction);
            reaction1.setDeclaration(declaration);
            reaction1.setUser(user);
            return Optional.of(reactionRepository.save(reaction1));
        }else {
            return  Optional.of(-1);

        }
    }
    @Transactional
    public  int delete(Integer id){
        return reactionRepository.deleteReactionsByIdReact(id);
    }

    public List<Reaction> findReactionsByDeclarationId(int id) {
        return reactionRepository.findReactionsByDeclarationId(id);
    }
}
