package com.example.ChallengeApp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {
    private ArrayList<Challenge> challenges = new ArrayList<>();

    public ChallengeController(){
        Challenge challenge1 = new Challenge(1L, "December", "Learn the spring boot ");
        challenges.add(challenge1);
    }

    @GetMapping("/challenges")
    public ArrayList<Challenge> getAllChallenges(){
        return challenges;
    }

    @PostMapping("/challenges")
    public String addChllenge(@RequestBody Challenge challenge){
        challenges.add(challenge);
        return "Challenge added successfully";
    }
}
