package com.fn.studentmanagement.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Error {
  private String code;
  private Object detail;

  public Error(Object detail) {
    this.detail = detail;
  }
}