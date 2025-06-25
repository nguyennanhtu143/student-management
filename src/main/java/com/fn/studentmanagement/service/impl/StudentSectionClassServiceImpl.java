package com.fn.studentmanagement.service.impl;

import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassRequest;
import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassResponse;
import com.fn.studentmanagement.entity.StudentSectionClass;
import com.fn.studentmanagement.exception.section_class.StudentEnrolledSectionClassException;
import com.fn.studentmanagement.exception.section_class.StudentNotEnrollSectionClassException;
import com.fn.studentmanagement.repository.StudentSectionClassRepository;
import com.fn.studentmanagement.service.StudentSectionClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentSectionClassServiceImpl implements StudentSectionClassService {
  private final StudentSectionClassRepository repository;

  @Override
  public void save(Integer studentId, StudentSectionClassRequest request) {
    log.info("(save) student section class request: {}", request);

    List<Integer> sectionClassIds = request.getSectionClassIds();
    for (int id : sectionClassIds) {
      if (repository.existsByStudentIdAndSectionClassId(studentId, id)) {
        throw new StudentEnrolledSectionClassException();
      }
      else {
        repository.save(this.toEntity(studentId, id));
      }
    }
  }

  @Override
  public void delete(Integer studentId, StudentSectionClassRequest request) {
    log.info("(delete) student section class request: {}", request);

    List<Integer> sectionClassIds = request.getSectionClassIds();
    for (int id : sectionClassIds) {
      if (!repository.existsByStudentIdAndSectionClassId(studentId, id)) {
        throw new StudentNotEnrollSectionClassException();
      }
      else {
        repository.deleteByStudentIdAndSectionClassId(studentId, id);
      }
    }
  }

  private StudentSectionClass toEntity(Integer studentId, Integer sectionClassId) {
    return new StudentSectionClass(
          sectionClassId,
          studentId,
          LocalDate.now()
    );
  }

  private StudentSectionClassResponse toResponse(
        StudentSectionClass studentSectionClass
  ) {
    return new StudentSectionClassResponse(
          studentSectionClass.getId(),
          studentSectionClass.getSectionClassId(),
          studentSectionClass.getStudentId(),
          studentSectionClass.getEnrollDate()
    );
  }
}
