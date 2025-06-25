package com.fn.studentmanagement.controller;

import com.fn.studentmanagement.dto.common.ResponseGeneral;
import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassRequest;
import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassResponse;
import com.fn.studentmanagement.dto.user.UpdateUserRequest;
import com.fn.studentmanagement.dto.user.UserRequest;
import com.fn.studentmanagement.dto.user.UserResponse;
import com.fn.studentmanagement.facade.StudentSectionClassFacadeService;
import com.fn.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.fn.studentmanagement.constant.StudentManagementConstant.SUCCESS_MESSAGE;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService service;
  private final StudentSectionClassFacadeService studentSectionClassFacadeService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseGeneral<UserResponse> create(
        @RequestBody UserRequest request
  ) {
    log.info("===start create user");

    return ResponseGeneral.ofCreated(
          SUCCESS_MESSAGE,
          service.create(request)
    );
  }

  @GetMapping("/{id}")
  public ResponseGeneral<UserResponse> find(
        @PathVariable Integer id
  ) {
    log.info("===start find user");

    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          service.find(id)
    );
  }

  @PutMapping("/{id}")
  public ResponseGeneral<UserResponse> update(
        @PathVariable Integer id,
        @RequestBody UpdateUserRequest request
  ) {
    log.info("===start update user");

    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          service.update(id, request)
    );
  }

  @DeleteMapping("/{id}")
  public ResponseGeneral<UserResponse> delete(
        @PathVariable Integer id
  ) {
    log.info("===start delete user");

    service.delete(id);
    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          null
    );
  }

  @PostMapping("/{id}/enrollment")
  public ResponseGeneral<Void> enrollSectionClass(
        @PathVariable Integer id,
        @RequestBody StudentSectionClassRequest request
  ) {
    log.info("===start enroll section class");

    studentSectionClassFacadeService.enroll(id, request);
    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          null
    );
  }

  @DeleteMapping("/{id}/un-enrollment")
  public ResponseGeneral<Void> unEnrollSectionClass(
        @PathVariable Integer id,
        @RequestBody StudentSectionClassRequest request
  ) {
    log.info("===start un-enroll section class");

    studentSectionClassFacadeService.unEnroll(id, request);
    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          null
    );
  }
}
