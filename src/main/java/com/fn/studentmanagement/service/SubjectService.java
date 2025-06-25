package com.fn.studentmanagement.service;

import com.fn.studentmanagement.dto.subject.SubjectRequest;
import com.fn.studentmanagement.dto.subject.SubjectResponse;

public interface SubjectService {
  SubjectResponse create(SubjectRequest request);

  SubjectResponse find(Integer id);

  SubjectResponse update(Integer id, SubjectRequest request);

  void delete(Integer id);
}
