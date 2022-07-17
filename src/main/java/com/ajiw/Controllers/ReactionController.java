package com.ajiw.Controllers;

import com.ajiw.entities.Reaction;
import com.ajiw.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reactions")

public class ReactionController {
    @Autowired
    ReactionService reactionService;
    @GetMapping("/newReaction/{userId}/{idDeclaration}/{reaction}")
    public Optional<?> saveReaction(@PathVariable int userId,@PathVariable Long idDeclaration,@PathVariable int reaction) {
        return reactionService.saveReaction(userId, idDeclaration, reaction);
    }
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable Integer id) {
        return reactionService.delete(id);
    }
@GetMapping("/find/{id}")
    public List<Reaction> findReactionsByDeclarationId(@PathVariable int id) {
        return reactionService.findReactionsByDeclarationId(id);
    }
}
