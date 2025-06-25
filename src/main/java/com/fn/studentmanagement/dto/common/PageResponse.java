package com.fn.studentmanagement.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PageResponse<T> {
  private List<T> data;
  private int total;

//  public static <T> PageResponse<T> of(List<T> data, int total) {
//    return of(data, total);
//  }
}
