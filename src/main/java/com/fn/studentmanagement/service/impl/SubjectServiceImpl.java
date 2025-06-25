package com.fn.studentmanagement.service.impl;

import com.fn.studentmanagement.dto.subject.SubjectRequest;
import com.fn.studentmanagement.dto.subject.SubjectResponse;
import com.fn.studentmanagement.entity.Subject;
import com.fn.studentmanagement.exception.subject.SubjectNotFoundException;
import com.fn.studentmanagement.repository.SubjectRepository;
import com.fn.studentmanagement.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
  private final SubjectRepository repository;

  @Override
  @Transactional
  public SubjectResponse create(SubjectRequest request) {
    log.info("(create) subject request: {}", request);

    return this.toResponse(repository.save(this.toEntity(request)));
  }

  @Override
  public SubjectResponse find(Integer id) {
    log.info("(find) subject id: {}", id);

    return this.toResponse(this.get(id));
  }

  @Override
  @Transactional
  public SubjectResponse update(Integer id, SubjectRequest request) {
    log.info("(update) subject id: {}, request: {}", id, request);

    Subject subject = this.get(id);
    if (isModified(subject, request)) {
      log.debug("apply change subject id: {}, request: {}", id, request);

      return this.toResponse(repository.save(this.applyChange(subject, request)));
    }

    return this.toResponse(subject);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    log.info("(delete) subject id: {}", id);

    repository.delete(this.get(id));
  }

  private Subject toEntity(SubjectRequest request) {
    return new Subject(
          request.getName(),
          request.getCredits(),
          request.getDepartmentId(),
          request.getGrade1Percent(),
          request.getGrade2Percent(),
          request.getGrade3Percent(),
          request.getExamGradePercent()
    );
  }

  private SubjectResponse toResponse(Subject subject) {
    return SubjectResponse.of(
          subject.getId(),
          subject.getName(),
          subject.getCredits(),
          subject.getDepartmentId(),
          subject.getGrade1Percent(),
          subject.getGrade2Percent(),
          subject.getGrade3Percent(),
          subject.getExamGradePercent()
    );
  }

  private Subject get(Integer id) {
    return repository.findById(id).orElseThrow(SubjectNotFoundException::new);
  }

  private boolean isModified(Subject subject, SubjectRequest request) {
    if (!subject.getName().equals(request.getName())) {
      return true;
    }
    if (!subject.getCredits().equals(request.getCredits())) {
      return true;
    }
    if (!subject.getDepartmentId().equals(request.getDepartmentId())) {
      return true;
    }
    if (!subject.getGrade1Percent().equals(request.getGrade1Percent())) {
      return true;
    }
    if (!subject.getGrade2Percent().equals(request.getGrade2Percent())) {
      return true;
    }
    if (!subject.getGrade3Percent().equals(request.getGrade3Percent())) {
      return true;
    }

    return !subject.getExamGradePercent().equals(request.getExamGradePercent());
  }

  private Subject applyChange(Subject subject, SubjectRequest request) {
    subject.setName(request.getName());
    subject.setCredits(request.getCredits());
    subject.setDepartmentId(request.getDepartmentId());
    subject.setGrade1Percent(request.getGrade1Percent());
    subject.setGrade2Percent(request.getGrade2Percent());
    subject.setGrade3Percent(request.getGrade3Percent());
    subject.setExamGradePercent(request.getExamGradePercent());
    return subject;
  }
}
