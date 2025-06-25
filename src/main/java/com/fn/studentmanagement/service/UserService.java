package com.fn.studentmanagement.service;

import com.fn.studentmanagement.dto.user.UpdateUserRequest;
import com.fn.studentmanagement.dto.user.UserRequest;
import com.fn.studentmanagement.dto.user.UserResponse;

public interface UserService {
  UserResponse create(UserRequest request);

  UserResponse find(Integer id);

  UserResponse update(Integer id, UpdateUserRequest request);

  void delete(Integer id);

  boolean exist(Integer id);
}
