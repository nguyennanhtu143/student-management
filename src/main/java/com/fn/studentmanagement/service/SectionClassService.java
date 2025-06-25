package com.fn.studentmanagement.service;

import com.fn.studentmanagement.dto.common.PageResponse;
import com.fn.studentmanagement.dto.section_class.SectionClassRequest;
import com.fn.studentmanagement.dto.section_class.SectionClassResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface SectionClassService {
  SectionClassResponse create(SectionClassRequest request);

  SectionClassResponse find(Integer id);

  PageResponse<SectionClassResponse> filter(
        String keyword,
        Integer semesterId,
        Integer subjectId,
        int page,
        int size
  );

  boolean exist(List<Integer> ids);

  PageResponse<SectionClassResponse> findAll(List<Integer> ids, PageRequest pageRequest);
}
