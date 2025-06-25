package com.fn.studentmanagement.service.impl;

import com.fn.studentmanagement.dto.semester.SemesterRequest;
import com.fn.studentmanagement.dto.semester.SemesterResponse;
import com.fn.studentmanagement.entity.Semester;
import com.fn.studentmanagement.repository.SemesterRepository;
import com.fn.studentmanagement.service.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SemesterServiceImpl implements SemesterService {
  private final SemesterRepository repository;

  @Override
  @Transactional
  public SemesterResponse create(SemesterRequest request) {
    log.info("(create) semester request: {}", request);

    return this.toResponse(repository.save(this.toEntity(request)));
  }

  private Semester toEntity(SemesterRequest request) {
    return new Semester(
          request.getCode(),
          request.getDescription(),
          request.getStartDate(),
          request.getEndDate()
    );
  }

  private SemesterResponse toResponse(Semester semester) {
    return SemesterResponse.of(
          semester.getId(),
          semester.getCode(),
          semester.getDescription(),
          semester.getStartDate(),
          semester.getEndDate()
    );
  }
}
