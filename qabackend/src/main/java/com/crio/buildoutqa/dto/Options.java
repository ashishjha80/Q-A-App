package com.crio.buildoutqa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options {
  @JsonProperty("1")
  @Field("1")
  private String firstOption;

  @JsonProperty("2")
  @Field("2")
  private String secondOption;

  @JsonProperty("3")
  @Field("3")
  private String thirdOption;

  @JsonProperty("4")
  @Field("4")
  private String fourthOption;

}