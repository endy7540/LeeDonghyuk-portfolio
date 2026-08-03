package com.leedonghyuk.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailDTO {
    private String name;             // ex. petmilyday
    private String tagline;          // 짧은 한 줄 설명
    private String description;      // 프로젝트 전체 소개 문단
    private String period;
    private String teamSize;
    private String role;

    private List<FeatureDTO> features;         // 서비스 기능 개요 카드
    private List<TechStackDTO> techStacks;     // 기술 스택
    private List<CaseStudyDTO> caseStudies;    // 문제 해결 사례
}
