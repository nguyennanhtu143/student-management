package com.fn.studentmanagement.dto.student_section_class;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentSectionClassResponse {
  private Integer id;
  private Integer sectionClassId;
  private Integer studentId;
  private LocalDate enrollDate;
  private Double grade1;
  private Double grade2;
  private Double grade3;
  private Double examGrade;
  private Double finalGrade;

  public StudentSectionClassResponse(Integer id, Integer sectionClassId, Integer studentId, LocalDate enrollDate) {
    this.id = id;
    this.sectionClassId = sectionClassId;
    this.studentId = studentId;
    this.enrollDate = enrollDate;
  }
}
