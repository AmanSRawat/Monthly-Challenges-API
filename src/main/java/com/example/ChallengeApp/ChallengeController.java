package com.example.ChallengeApp;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping
    public ArrayList<Challenge> getAllChallenges(){
        return challengeService.getAllChallenges();
    }

    @PostMapping
    public ResponseEntity<String> addChllenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChllenge(challenge);
        if(isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully!",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not added successfully!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge != null)
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id,updatedChallenge);
         if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated successfully!",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not updated successfully!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted)
            return new ResponseEntity<>("Challenge deleted successfully!",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge not deleted successfully!",HttpStatus.NOT_FOUND);
    }
}
