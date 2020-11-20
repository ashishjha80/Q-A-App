package com.crio.buildoutqa.exchange;

import com.crio.buildoutqa.dto.Question;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuestions {
  private List<Question> questions = new ArrayList<>();
}