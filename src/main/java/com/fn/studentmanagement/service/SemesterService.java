package com.fn.studentmanagement.service;

import com.fn.studentmanagement.dto.semester.SemesterRequest;
import com.fn.studentmanagement.dto.semester.SemesterResponse;

public interface SemesterService {
  SemesterResponse create(SemesterRequest request);
}
