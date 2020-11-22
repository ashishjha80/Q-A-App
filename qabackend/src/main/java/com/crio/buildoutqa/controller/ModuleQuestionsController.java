package com.crio.buildoutqa.controller;

import com.crio.buildoutqa.exchange.GetQuestions;
import com.crio.buildoutqa.exchange.UserSubmissionRequest;
import com.crio.buildoutqa.exchange.UserSubmissionRequestResult;
import com.crio.buildoutqa.service.ModuleQuestionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleQuestionsController {
  @Autowired  
  private ModuleQuestionsService moduleQuestionsService;

  @GetMapping("/quiz/1")
  public ResponseEntity<GetQuestions> getQuestions() {
    GetQuestions getQuestions;
    getQuestions = moduleQuestionsService.findAllQuestionsForModule();
    return ResponseEntity.ok().body(getQuestions);
  }
  
  @PostMapping("/quiz/1")
  public ResponseEntity<UserSubmissionRequestResult> getUserResult(@RequestBody 
          UserSubmissionRequest userSubmissionRequest) {
    UserSubmissionRequestResult userSubmissionRequestResult;
    userSubmissionRequestResult = moduleQuestionsService
            .getResultsForUser(userSubmissionRequest);
    return ResponseEntity.ok().body(userSubmissionRequestResult);
  }

}