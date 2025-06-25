package com.fn.studentmanagement.exception.subject;

import com.fn.studentmanagement.exception.base.BaseException;

import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND;
import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND_MESSAGE;

public class SubjectNotFoundException extends BaseException {
  private static final String SUBJECT_NOT_FOUND = "Subject Not Found";

  public SubjectNotFoundException() {
    super(NOT_FOUND, NOT_FOUND_MESSAGE, SUBJECT_NOT_FOUND);
  }
}
