package com.fn.studentmanagement.controller;

import com.fn.studentmanagement.dto.common.ResponseGeneral;
import com.fn.studentmanagement.dto.semester.SemesterRequest;
import com.fn.studentmanagement.dto.semester.SemesterResponse;
import com.fn.studentmanagement.service.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.fn.studentmanagement.constant.StudentManagementConstant.SUCCESS_MESSAGE;

@RestController
@RequestMapping("api/v1/semesters")
@Slf4j
@RequiredArgsConstructor
public class SemesterController {
  private final SemesterService semesterService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseGeneral<SemesterResponse> create(
        @RequestBody SemesterRequest request
  ) {
    log.info("===start create semester");

    return ResponseGeneral.ofCreated(
          SUCCESS_MESSAGE,
          semesterService.create(request)
    );
  }
}
