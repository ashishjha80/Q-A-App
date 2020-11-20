package com.crio.buildoutqa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWithAnswersAndUserResponse {
  @JsonProperty("questionId")
  @Field("question_id")
  private String questionId;
  private String title;
  private String description;
  private String type;
  private Options options;
  private List<String> userAnswer = new ArrayList<>();

  @JsonProperty("correct")
  private List<String> correctAnswer = new ArrayList<>();
  private String explanation;
  
  @JsonProperty("answerCorrect")
  private Boolean isAnswerCorrect;

}