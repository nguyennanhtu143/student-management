package com.fn.studentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String password;
  private String code;
  private String name;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;
  private String address;
  private String phone;
  private String role;
  private Integer departmentId;

  public User(
        String username,
        String password,
        String code,
        String name,
        LocalDate dateOfBirth,
        String address,
        String phone,
        String role,
        Integer departmentId
  ) {
    this.username = username;
    this.password = password;
    this.code = code;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.phone = phone;
    this.role = role;
    this.departmentId = departmentId;
  }
}
