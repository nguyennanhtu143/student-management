package com.fn.studentmanagement.exception.section_class;

import com.fn.studentmanagement.exception.base.BaseException;

import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND;
import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND_MESSAGE;

public class SectionClassNotFoundException extends BaseException {
  private static final String SECTION_CLASS_NOT_FOUND = "Section class not found";
  public SectionClassNotFoundException() {
    super(NOT_FOUND, NOT_FOUND_MESSAGE, SECTION_CLASS_NOT_FOUND);
  }
}
