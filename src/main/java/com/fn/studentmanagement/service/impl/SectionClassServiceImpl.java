package com.fn.studentmanagement.service.impl;

import com.fn.studentmanagement.dto.common.PageResponse;
import com.fn.studentmanagement.dto.section_class.SectionClassRequest;
import com.fn.studentmanagement.dto.section_class.SectionClassResponse;
import com.fn.studentmanagement.entity.SectionClass;
import com.fn.studentmanagement.exception.section_class.SectionClassNotFoundException;
import com.fn.studentmanagement.repository.SectionClassRepository;
import com.fn.studentmanagement.service.SectionClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SectionClassServiceImpl implements SectionClassService {
  private final SectionClassRepository repository;

  @Override
  @Transactional
  public SectionClassResponse create(SectionClassRequest request) {
    log.info("(create) section class request: {}", request);

    return this.toResponse(repository.save(this.toEntity(request)));
  }

  @Override
  public SectionClassResponse find(Integer id) {
    log.info("(find) section class request: {}", id);

    return this.toResponse(this.get(id));
  }

  @Override
  public PageResponse<SectionClassResponse> filter(
        String keyword,
        Integer semesterId,
        Integer subjectId,
        int page,
        int size
  ) {
    log.info("(filter) section class keyword: {}, semester: {}, subject: {}", keyword, semesterId, subjectId);

    PageRequest pageRequest = PageRequest.of(page, size);

    Page<SectionClassResponse> sectionClassResponses
          = repository.filter(keyword, semesterId, subjectId, pageRequest);

    List<SectionClassResponse> responses = sectionClassResponses.getContent();
    return PageResponse.of(
          responses,
          responses.size()
    );
  }

  @Override
  public boolean exist(List<Integer> ids) {
    log.info("(exist) section class request: {}", ids);

    for (Integer id : ids) {
      if (!repository.existsById(id)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public PageResponse<SectionClassResponse> findAll(List<Integer> ids, PageRequest pageRequest) {
    log.info("(findAll) section class request: {}", ids);

    List<SectionClassResponse> sectionClassResponses = repository.findAll(ids, pageRequest).getContent();
    return PageResponse.of(
            sectionClassResponses,
            sectionClassResponses.size()
    );
  }

  private SectionClass toEntity(SectionClassRequest request) {
    return new SectionClass(
          request.getCode(),
          request.getSubjectId(),
          request.getTeacherId(),
          request.getSemesterId(),
          request.getRoom(),
          request.getStartDate(),
          request.getEndDate(),
          request.getStartTime(),
          request.getEndTime(),
          request.getDayOfWeek()
    );
  }

  private SectionClassResponse toResponse(SectionClass sectionClass) {
    return SectionClassResponse.of(
          sectionClass.getId(),
          sectionClass.getCode(),
          sectionClass.getSubjectId(),
          sectionClass.getTeacherId(),
          sectionClass.getSemesterId(),
          sectionClass.getRoom(),
          sectionClass.getStartDate(),
          sectionClass.getEndDate(),
          sectionClass.getStartTime(),
          sectionClass.getEndTime(),
          sectionClass.getDayOfWeek()
    );
  }

  private SectionClass get(Integer id) {
    return repository.findById(id).orElseThrow(SectionClassNotFoundException::new);
  }
}
