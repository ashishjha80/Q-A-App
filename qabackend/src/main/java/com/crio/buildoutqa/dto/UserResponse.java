package com.crio.buildoutqa.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
  private String questionId;
  private List<String> userResponse = new ArrayList<>();
}