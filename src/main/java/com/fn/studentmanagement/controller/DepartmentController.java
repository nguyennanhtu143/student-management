package com.fn.studentmanagement.controller;

import com.fn.studentmanagement.dto.common.ResponseGeneral;
import com.fn.studentmanagement.dto.department.DepartmentRequest;
import com.fn.studentmanagement.dto.department.DepartmentResponse;
import com.fn.studentmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.fn.studentmanagement.constant.StudentManagementConstant.SUCCESS_MESSAGE;

@RestController
@RequestMapping("api/v1/departments")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseGeneral<DepartmentResponse> create(
        @RequestBody DepartmentRequest request
  ) {
    log.info("===start create department");

    return ResponseGeneral.of(
          HttpStatus.CREATED.value(),
          SUCCESS_MESSAGE,
          service.create(request)
    );
  }
}
