package com.fn.studentmanagement.dto.section_class;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SectionClassRequest {
  private String code;
  private Integer subjectId;
  private Integer teacherId;
  private Integer semesterId;
  private String room;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate startDate;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate endDate;
  private LocalTime startTime;
  private LocalTime endTime;
  private String dayOfWeek;
}
