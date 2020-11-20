package com.crio.buildoutqa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  @Field("question_id")
  private String questionId;
  
  private String title;
  private String type;
  private Options options;

}