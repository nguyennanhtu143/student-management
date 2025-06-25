package com.fn.studentmanagement.repository;

import com.fn.studentmanagement.entity.StudentSectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSectionClassRepository extends JpaRepository<StudentSectionClass, Integer> {
  boolean existsByStudentIdAndSectionClassId(Integer studentId, int id);

  void deleteByStudentIdAndSectionClassId(Integer studentId, int id);
}
