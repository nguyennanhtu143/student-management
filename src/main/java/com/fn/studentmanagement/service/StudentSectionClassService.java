package com.fn.studentmanagement.service;

import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassRequest;

import java.util.List;

public interface StudentSectionClassService {
  void save(Integer studentId, StudentSectionClassRequest request);

  void delete(Integer studentId, StudentSectionClassRequest request);

  List<Integer> findAll(Integer studentId);
}
