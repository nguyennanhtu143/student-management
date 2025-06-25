package com.fn.studentmanagement.repository;

import com.fn.studentmanagement.dto.section_class.SectionClassFilterRequest;
import com.fn.studentmanagement.dto.section_class.SectionClassResponse;
import com.fn.studentmanagement.entity.SectionClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionClassRepository extends JpaRepository<SectionClass, Integer> {

  @Query("SELECT new com.fn.studentmanagement.dto.section_class.SectionClassResponse(" +
        "sc.id, sc.code, sc.subjectId, sc.teacherId, sc.semesterId, sc.room, " +
        "sc.startDate, sc.endDate, sc.startTime, sc.endTime, sc.dayOfWeek) " +
        "FROM SectionClass sc " +
        "WHERE (:keyword IS NULL OR sc.code LIKE %:keyword%) " +
        "AND (:semesterId IS NULL OR sc.semesterId = :semesterId) " +
        "AND (:subjectId IS NULL OR sc.subjectId = :subjectId)")
  Page<SectionClassResponse> filter(
        @Param("keyword") String keyword,
        @Param("semesterId") Integer semesterId,
        @Param("subjectId") Integer subjectId,
        Pageable pageable
  );

  @Query("SELECT new com.fn.studentmanagement.dto.section_class.SectionClassResponse(" +
          "sc.id, sc.code, sc.subjectId, sc.teacherId, sc.semesterId, sc.room, " +
          "sc.startDate, sc.endDate, sc.startTime, sc.endTime, sc.dayOfWeek) " +
          "FROM SectionClass sc " +
          "WHERE sc.id in :ids")
  Page<SectionClassResponse> findAll(@Param("ids") List<Integer> ids, Pageable pageable);
}
