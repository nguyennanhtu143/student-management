package com.fn.studentmanagement.facade.impl;

import com.fn.studentmanagement.dto.common.PageResponse;
import com.fn.studentmanagement.dto.section_class.SectionClassResponse;
import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassRequest;
import com.fn.studentmanagement.exception.section_class.SectionClassNotFoundException;
import com.fn.studentmanagement.exception.user.UserNotFoundException;
import com.fn.studentmanagement.facade.StudentSectionClassFacadeService;
import com.fn.studentmanagement.service.SectionClassService;
import com.fn.studentmanagement.service.StudentSectionClassService;
import com.fn.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentSectionClassFacadeServiceImpl implements StudentSectionClassFacadeService {
  private final UserService userService;
  private final StudentSectionClassService studentSectionClassService;
  private final SectionClassService sectionClassService;

  @Override
  @Transactional
  public void enroll(
        Integer studentId,
        StudentSectionClassRequest request
  ) {
    log.info("(enroll) Section Class Request: {}", request);

    if (!userService.exist(studentId)) {
      throw new UserNotFoundException();
    }

    if (sectionClassService.exist(request.getSectionClassIds())) {
      throw new SectionClassNotFoundException();
    }

    studentSectionClassService.save(studentId, request);
  }

  @Override
  @Transactional
  public void unEnroll(Integer studentId, StudentSectionClassRequest request) {
    log.info("(unEnroll) Section Class Request: {}", request);

    if (!userService.exist(studentId)) {
      throw new UserNotFoundException();
    }
    if (sectionClassService.exist(request.getSectionClassIds())) {
      throw new SectionClassNotFoundException();
    }

    studentSectionClassService.delete(studentId, request);
  }

  @Override
  public PageResponse<SectionClassResponse> findAllSectionClassEnrolled(
          Integer studentId,
          int page,
          int size
  ) {
    log.info("(findAllSectionClassEnrolled) of student id: {}", studentId);

    List<Integer> sectionClassIds = studentSectionClassService.findAll(studentId);

    return sectionClassService.findAll(sectionClassIds, PageRequest.of(page, size));
  }
}
