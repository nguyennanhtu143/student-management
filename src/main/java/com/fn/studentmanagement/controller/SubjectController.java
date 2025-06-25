package com.fn.studentmanagement.controller;

import com.fn.studentmanagement.dto.common.ResponseGeneral;
import com.fn.studentmanagement.dto.subject.SubjectRequest;
import com.fn.studentmanagement.dto.subject.SubjectResponse;
import com.fn.studentmanagement.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.fn.studentmanagement.constant.StudentManagementConstant.SUCCESS_MESSAGE;

@RestController
@RequestMapping("api/v1/subjects")
@Slf4j
@RequiredArgsConstructor
public class SubjectController {
  private final SubjectService service;

  //API create subject, return subject response
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseGeneral<SubjectResponse> create(
        @RequestBody SubjectRequest request
  ) {
    log.info("===start create subject");

    return ResponseGeneral.ofCreated(
          SUCCESS_MESSAGE,
          service.create(request)
    );
  }

  @GetMapping("/{id}")
  public ResponseGeneral<SubjectResponse> find(
        @PathVariable Integer id
  ) {
    log.info("===start find subject");

    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          service.find(id)
    );
  }

  @PutMapping("/{id}")
  public ResponseGeneral<SubjectResponse> update(
        @PathVariable Integer id,
        @RequestBody SubjectRequest request
  ) {
    log.info("===start update subject");

    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          service.update(id, request)
    );
  }

  @DeleteMapping("/{id}")
  public ResponseGeneral<Void> delete(@PathVariable Integer id) {
    log.info("===start delete subject");

    service.delete(id);
    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          null
    );
  }
}
