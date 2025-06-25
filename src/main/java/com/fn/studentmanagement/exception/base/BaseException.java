package com.fn.studentmanagement.exception.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BaseException extends RuntimeException {
  private final int status;
  private final String message;
  private final String details;
}
