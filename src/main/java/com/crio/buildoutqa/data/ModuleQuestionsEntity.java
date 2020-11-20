package com.crio.buildoutqa.data;

import com.crio.buildoutqa.dto.Options;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "modulequestions")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleQuestionsEntity {
  
  //@Field("question_id")
  private String questionId;

  private String title;
  private String description;
  private String type;
  private Options options;
  
  //@Field("correct_answer")
  private List<String> correctAnswer = new ArrayList<>();
}