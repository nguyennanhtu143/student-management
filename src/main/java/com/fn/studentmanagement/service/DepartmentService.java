package com.fn.studentmanagement.service;

import com.fn.studentmanagement.dto.department.DepartmentRequest;
import com.fn.studentmanagement.dto.department.DepartmentResponse;

public interface DepartmentService {
  DepartmentResponse create(DepartmentRequest request);
}
