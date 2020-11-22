package com.crio.buildoutqa.exchange;

import com.crio.buildoutqa.dto.QuestionWithAnswersAndUserResponse;
import com.crio.buildoutqa.dto.Summary;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSubmissionRequestResult {
  private List<QuestionWithAnswersAndUserResponse> questions = new ArrayList<>();
  private Summary summary;
}