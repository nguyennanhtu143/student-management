package com.fn.studentmanagement.dto.subject;

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
public class SubjectRequest {
  private String name;
  private Integer credits;
  private Integer departmentId;
  private Double grade1Percent;
  private Double grade2Percent;
  private Double grade3Percent;
  private Double examGradePercent;
}
