package com.fn.studentmanagement.facade;

import com.fn.studentmanagement.dto.common.PageResponse;
import com.fn.studentmanagement.dto.section_class.SectionClassResponse;
import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassRequest;
import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassResponse;

public interface StudentSectionClassFacadeService {
  void enroll(Integer studentId, StudentSectionClassRequest request);

  void unEnroll(Integer studentId, StudentSectionClassRequest request);

  PageResponse<SectionClassResponse> findAllSectionClassEnrolled(Integer studentId, int page, int size);
}
