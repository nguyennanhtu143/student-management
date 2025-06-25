package com.fn.studentmanagement.dto.user;

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
public class UserResponse {
  private Integer id;
  private String username;
  private String password;
  private String code;
  private String name;
  private LocalDate dateOfBirth;
  private String address;
  private String phone;
  private String role;
  private Integer departmentId;
}
