package com.crio.buildoutqa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  private String questionId;
  private String title;
  private String type;
  private Options options;

}