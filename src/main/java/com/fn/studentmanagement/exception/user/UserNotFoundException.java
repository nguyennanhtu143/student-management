package com.fn.studentmanagement.exception.user;

import com.fn.studentmanagement.exception.base.BaseException;

import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND;
import static com.fn.studentmanagement.constant.StudentManagementConstant.NOT_FOUND_MESSAGE;

public class UserNotFoundException extends BaseException {
  private static final String USER_NOT_FOUND = "User not found";
  public UserNotFoundException() {
    super(NOT_FOUND, NOT_FOUND_MESSAGE, USER_NOT_FOUND);
  }
}
