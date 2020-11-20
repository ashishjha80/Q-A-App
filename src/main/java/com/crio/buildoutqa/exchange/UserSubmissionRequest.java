package com.crio.buildoutqa.exchange;

import com.crio.buildoutqa.dto.UserResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSubmissionRequest {
  private List<UserResponse> responses = new ArrayList<>();
  
}