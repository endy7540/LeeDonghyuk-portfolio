package com.leedonghyuk.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationDTO {
    private String name;    // 학교명 / 기관명
    private String detail;  // 전공 또는 과정명
    private String period;  // 기간
}
