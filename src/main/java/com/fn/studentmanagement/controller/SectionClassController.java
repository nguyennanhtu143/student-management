package com.fn.studentmanagement.controller;

import com.fn.studentmanagement.dto.common.PageResponse;
import com.fn.studentmanagement.dto.common.ResponseGeneral;
import com.fn.studentmanagement.dto.section_class.SectionClassRequest;
import com.fn.studentmanagement.dto.section_class.SectionClassResponse;
import com.fn.studentmanagement.service.SectionClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.fn.studentmanagement.constant.StudentManagementConstant.SUCCESS_MESSAGE;

@RestController
@RequestMapping("api/v1/section-classes")
@Slf4j
@RequiredArgsConstructor
public class SectionClassController {
  private final SectionClassService sectionClassService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseGeneral<SectionClassResponse> create(
        @RequestBody SectionClassRequest request
  ) {
    log.info("===start create section class");

    return ResponseGeneral.ofCreated(
          SUCCESS_MESSAGE,
          sectionClassService.create(request)
    );
  }

  @GetMapping("/filter")
  public ResponseGeneral<PageResponse<SectionClassResponse>> filter(
        @RequestParam(required = false) String keyword,
        @RequestParam(required = false) Integer semesterId,
        @RequestParam(required = false) Integer subjectId,
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
  ) {
    log.info("===start filter section class");

    return ResponseGeneral.ofSuccess(
          SUCCESS_MESSAGE,
          sectionClassService.filter(keyword, semesterId, subjectId, page, size)
    );
  }

  @GetMapping("/{id}")
  public ResponseGeneral<SectionClassResponse> find(
        @PathVariable Integer id
  ) {
    log.info("===start find section class");

    return ResponseGeneral.ofCreated(
          SUCCESS_MESSAGE,
          sectionClassService.find(id)
    );
  }
}
