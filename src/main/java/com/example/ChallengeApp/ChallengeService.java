package com.example.ChallengeApp;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ChallengeService {
    private ArrayList<Challenge> challenges = new ArrayList<>();
    private Long nextID = 1L;

    public ChallengeService(){
        Challenge challenge1 = new Challenge(1L, "December", "Learn the spring boot ");
        challenges.add(challenge1);
    }

    public ArrayList<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChllenge(@RequestBody Challenge challenge){
        if(challenge!= null){
            challenge.setId(nextID++);
            challenges.add(challenge);
            return true;
        }else{
            return false;
        }
    }

    public Challenge getChallenge(String month){
        for(Challenge challenge: challenges){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for(Challenge challenge: challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge->challenge.getId().equals(id));
    }
}
