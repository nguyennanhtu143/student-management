package com.fn.studentmanagement.dto.section_class;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SectionClassFilterRequest {
  private String keyword;
  private Integer semesterId;
  private Integer subjectId;

  private int page = 0;
  private int size = 10;

}
