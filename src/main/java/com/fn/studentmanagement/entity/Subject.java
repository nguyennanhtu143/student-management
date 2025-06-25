package com.fn.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Integer credits;
  private Integer departmentId;

  @Column(name = "grade1_percent")
  private Double grade1Percent;

  @Column(name = "grade2_percent")
  private Double grade2Percent;

  @Column(name = "grade3_percent")
  private Double grade3Percent;

  @Column(name = "exam_grade_percent")
  private Double examGradePercent;

  public Subject(String name, Integer credits, Integer departmentId, Double grade1Percent, Double grade2Percent, Double grade3Percent, Double examGradePercent) {
    this.name = name;
    this.credits = credits;
    this.departmentId = departmentId;
    this.grade1Percent = grade1Percent;
    this.grade2Percent = grade2Percent;
    this.grade3Percent = grade3Percent;
    this.examGradePercent = examGradePercent;
  }
}
