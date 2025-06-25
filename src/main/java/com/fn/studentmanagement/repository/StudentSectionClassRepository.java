package com.fn.studentmanagement.repository;

import com.fn.studentmanagement.dto.student_section_class.StudentSectionClassResponse;
import com.fn.studentmanagement.entity.StudentSectionClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSectionClassRepository extends JpaRepository<StudentSectionClass, Integer> {
  boolean existsByStudentIdAndSectionClassId(Integer studentId, int id);

  void deleteByStudentIdAndSectionClassId(Integer studentId, int id);

  @Query("SELECT new com.fn.studentmanagement.dto.student_section_class.StudentSectionClassResponse (" +
          "ssc.id, ssc.sectionClassId, ssc.studentId, ssc.enrollDate ) " +
          "FROM StudentSectionClass ssc WHERE " +
          ":studentId=ssc.studentId"
  )
  Page<StudentSectionClassResponse> filter(
          @Param("studentId") Integer studentId,
          Pageable pageable
  );

  @Query("SELECT ssc.sectionClassId FROM StudentSectionClass ssc WHERE ssc.studentId = :studentId")
  List<Integer> findAllSectionClassIdByStudentId(@Param("studentId") Integer studentId);
}
