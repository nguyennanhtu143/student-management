package com.fn.studentmanagement.service.impl;

import com.fn.studentmanagement.dto.department.DepartmentRequest;
import com.fn.studentmanagement.dto.department.DepartmentResponse;
import com.fn.studentmanagement.entity.Department;
import com.fn.studentmanagement.repository.DepartmentRepository;
import com.fn.studentmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
  private final DepartmentRepository repository;

  @Override
  @Transactional
  public DepartmentResponse create(DepartmentRequest request) {
    log.info("(create) department request: {}", request);

    return this.toResponse(repository.save(this.toEntity(request)));
  }

  private Department toEntity(DepartmentRequest request) {
    return new Department(
          request.getName(),
          request.getCode()
    );
  }

  private DepartmentResponse toResponse(Department department) {
    return DepartmentResponse.of(
          department.getId(),
          department.getName(),
          department.getCode()
    );
  }
}
