package com.fn.studentmanagement.exception.section_class;

import com.fn.studentmanagement.exception.base.BaseException;

import static com.fn.studentmanagement.constant.StudentManagementConstant.CONFLICT;
import static com.fn.studentmanagement.constant.StudentManagementConstant.CONFLICT_MESSAGE;

public class StudentEnrolledSectionClassException extends BaseException {
  private static final String STUDENT_ENROLLED_CLASS = "Student already enrolled section class";
  public StudentEnrolledSectionClassException() {
    super(CONFLICT, CONFLICT_MESSAGE, STUDENT_ENROLLED_CLASS);
  }
}
