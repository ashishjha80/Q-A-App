package com.crio.buildoutqa.service;

import com.crio.buildoutqa.exchange.GetQuestions;
import com.crio.buildoutqa.exchange.UserSubmissionRequest;
import com.crio.buildoutqa.exchange.UserSubmissionRequestResult;

public interface ModuleQuestionsService {

  GetQuestions findAllQuestionsForModule();

  UserSubmissionRequestResult getResultsForUser(UserSubmissionRequest 
      userSubmissionRequest);
}