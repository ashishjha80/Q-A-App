package com.crio.buildoutqa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.crio.buildoutqa.data.ModuleQuestionsEntity;
import com.crio.buildoutqa.exchange.GetQuestions;
import com.crio.buildoutqa.exchange.UserSubmissionRequest;
import com.crio.buildoutqa.exchange.UserSubmissionRequestResult;
import com.crio.buildoutqa.repository.ModuleQuestionsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.util.ResourceUtils;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class ModuleQuestionsServiceTest {

  protected ObjectMapper objectMapper;

  @Mock
  private ModuleQuestionsRepository moduleQuestionsRepository;

  @InjectMocks  
  private ModuleQuestionsServiceImpl moduleQuestionsService;

  @BeforeEach
  void setup() throws IOException, URISyntaxException {
    List<ModuleQuestionsEntity> allQuestions = listOfQuestions();
    
    when(moduleQuestionsRepository.findAll()).thenReturn(allQuestions);
  }

  private List<ModuleQuestionsEntity> listOfQuestions() throws IOException, 
      URISyntaxException {
    objectMapper = new ObjectMapper();
    File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX
            + "loadQuestions.json");
    return objectMapper.readValue(file, 
            new TypeReference<List<ModuleQuestionsEntity>>() {
      }); 
  }

  @Test
  void getQuestionsTest() throws IOException, URISyntaxException {
    GetQuestions expectedResponse = getResponse();
    GetQuestions response = moduleQuestionsService.findAllQuestionsForModule();
    assertEquals(expectedResponse, response);
  }

  @Test
  void getUserResult() throws IOException, URISyntaxException  {
    UserSubmissionRequest request = getRequest();
    UserSubmissionRequestResult expectedResponse = getPostResponse();
    UserSubmissionRequestResult response = moduleQuestionsService
            .getResultsForUser(request);
    assertEquals(expectedResponse, response);
  }

  private UserSubmissionRequestResult getPostResponse() 
      throws IOException, URISyntaxException {
    objectMapper = new ObjectMapper();
    File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX 
            + "postRequestResponse.json");
    
    return objectMapper.readValue(file, UserSubmissionRequestResult.class); 
  }

  private UserSubmissionRequest getRequest() throws IOException, URISyntaxException {
    objectMapper = new ObjectMapper();
    File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX 
            + "userSubmissionRequest.json");
    
    return objectMapper.readValue(file, UserSubmissionRequest.class); 
  }

  private GetQuestions getResponse() throws IOException, URISyntaxException {
    objectMapper = new ObjectMapper();
    File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX 
            + "getRequestResponse.json");
    
    return objectMapper.readValue(file, GetQuestions.class); 
  }

}