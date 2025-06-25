package com.fn.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student_section_class")
@Data
@NoArgsConstructor
public class StudentSectionClass {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer sectionClassId;
  private Integer studentId;
  private LocalDate enrollDate;
  private Double grade1;
  private Double grade2;
  private Double grade3;
  private Double examGrade;
  private Double finalGrade;

  public StudentSectionClass(Integer sectionClassId, Integer studentId, LocalDate enrollDate) {
    this.sectionClassId = sectionClassId;
    this.studentId = studentId;
    this.enrollDate = enrollDate;
  }
}
