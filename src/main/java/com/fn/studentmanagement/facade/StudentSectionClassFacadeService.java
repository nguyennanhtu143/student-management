package com.fn.studentmanagement.facade;

import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassRequest;

public interface StudentSectionClassFacadeService {
  void enroll(Integer studentId, StudentSectionClassRequest request);

  void unEnroll(Integer studentId, StudentSectionClassRequest request);
}
