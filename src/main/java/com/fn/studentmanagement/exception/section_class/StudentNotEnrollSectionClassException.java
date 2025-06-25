package com.fn.studentmanagement.exception.section_class;

import com.fn.studentmanagement.exception.base.BaseException;

import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND;
import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND_MESSAGE;

public class StudentNotEnrollSectionClassException extends BaseException {
  private static final String STUDENT_NOT_ENROLL = "Student not enroll this class";
  public StudentNotEnrollSectionClassException() {
    super(NOT_FOUND, NOT_FOUND_MESSAGE, STUDENT_NOT_ENROLL);
  }

}
