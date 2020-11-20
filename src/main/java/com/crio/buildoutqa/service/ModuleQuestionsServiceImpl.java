package com.crio.buildoutqa.service;

import com.crio.buildoutqa.data.ModuleQuestionsEntity;
import com.crio.buildoutqa.dto.Question;
import com.crio.buildoutqa.dto.QuestionWithAnswersAndUserResponse;
import com.crio.buildoutqa.dto.Summary;
import com.crio.buildoutqa.dto.UserResponse;
import com.crio.buildoutqa.exchange.GetQuestions;
import com.crio.buildoutqa.exchange.UserSubmissionRequest;
import com.crio.buildoutqa.exchange.UserSubmissionRequestResult;
import com.crio.buildoutqa.repository.ModuleQuestionsRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleQuestionsServiceImpl implements ModuleQuestionsService {

  @Autowired
  private ModuleQuestionsRepository moduleQuestionsRepository;

  public GetQuestions findAllQuestionsForModule() {
    List<ModuleQuestionsEntity> questionWithAnswers = moduleQuestionsRepository
            .findAll();
    System.out.println(questionWithAnswers);
    System.out.println("endl");
    List<Question> questions = new ArrayList<>();
    ModelMapper modelMapper = new ModelMapper();
    for (ModuleQuestionsEntity ques : questionWithAnswers) {
      Question question = modelMapper.map(ques,Question.class);
      questions.add(question);
    }
    System.out.println(questions);
    return new GetQuestions(questions);
  }
  
  public UserSubmissionRequestResult getResultsForUser(
      UserSubmissionRequest userSubmissionRequest) {
        
    List<UserResponse> responses = userSubmissionRequest.getResponses();
    System.out.println(responses);
    System.out.println("endl");
    Collections.sort(responses,Comparator.comparing(UserResponse::getQuestionId));
    List<ModuleQuestionsEntity> questionWithAnswers = moduleQuestionsRepository
            .findAll();
    System.out.println(questionWithAnswers);
    System.out.println("endl");
    Collections.sort(questionWithAnswers,Comparator.comparing(ModuleQuestionsEntity
            ::getQuestionId));
    List<QuestionWithAnswersAndUserResponse> questionsResult = new ArrayList<>();
    int n = questionWithAnswers.size();
    ModelMapper modelMapper = new ModelMapper();
    int count = 0;
    for (int i = 0;i < n; i++) {
      QuestionWithAnswersAndUserResponse currQuestion = modelMapper.map(questionWithAnswers.get(i),
              QuestionWithAnswersAndUserResponse.class);
      currQuestion.setUserAnswer(responses.get(i).getUserResponse());
      if (currQuestion.getUserAnswer().equals(currQuestion.getCorrectAnswer())) {
        count++;
        currQuestion.setIsAnswerCorrect(true);
      } else {
        currQuestion.setIsAnswerCorrect(false);
      }
      currQuestion.setExplanation(null);
      questionsResult.add(currQuestion);
    }
    System.out.println(questionsResult);
    System.out.println("endl");
    Summary summary = new Summary(count,n);
    System.out.println(summary);
    System.out.println("endl");
    return new UserSubmissionRequestResult(questionsResult, summary);
    
  }
}