package com.fn.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "section_classes")
@Data
@NoArgsConstructor
public class SectionClass {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String code;
  private Integer subjectId;
  private Integer teacherId;
  private Integer semesterId;
  private String room;
  private LocalDate startDate;
  private LocalDate endDate;
  private LocalTime startTime;
  private LocalTime endTime;
  private String dayOfWeek;

  public SectionClass(String code, Integer subjectId, Integer teacherId, Integer semesterId, String room, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String dayOfWeek) {
    this.code = code;
    this.subjectId = subjectId;
    this.teacherId = teacherId;
    this.semesterId = semesterId;
    this.room = room;
    this.startDate = startDate;
    this.endDate = endDate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.dayOfWeek = dayOfWeek;
  }
}
