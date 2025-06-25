package com.fn.studentmanagement.exception.user;

import com.fn.studentmanagement.exception.base.BaseException;

import static com.fn.studentmanagement.constant.StudentManagementConstant.CONFLICT;
import static com.fn.studentmanagement.constant.StudentManagementConstant.CONFLICT_MESSAGE;

public class UsernameExistedException extends BaseException {
  private static final String USERNAME_EXISTED = "Username already existed";
  public UsernameExistedException() {
    super(CONFLICT, CONFLICT_MESSAGE, USERNAME_EXISTED);
  }
}
