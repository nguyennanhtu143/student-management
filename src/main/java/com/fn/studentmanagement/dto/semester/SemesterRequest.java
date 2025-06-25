package com.fn.studentmanagement.dto.semester;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SemesterRequest {
  private String code;
  private String description;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate startDate;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate endDate;
}
