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
public class CaseStudyDTO {

    private String title;          // 카드 제목 (ex. "JWT + OAuth2 소셜 로그인 통합 인증 구조")
    private String badge;          // 짧은 태그 (ex. "인증/보안")
    private String summary;        // 한 줄 요약

    private List<String> problem;
    private List<String> approach;
    private List<String> action;
    private List<String> result;
}
