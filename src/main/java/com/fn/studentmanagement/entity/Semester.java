package com.fn.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "semesters")
@Data
@NoArgsConstructor
public class Semester {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String code;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;

  public Semester(String code, String description, LocalDate startDate, LocalDate endDate) {
    this.code = code;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
  }
}
