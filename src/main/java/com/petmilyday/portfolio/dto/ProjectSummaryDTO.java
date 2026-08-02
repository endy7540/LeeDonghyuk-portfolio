package com.petmilyday.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSummaryDTO {
    private String slug;             // URL 경로 (ex. "petmilyday" -> /projects/petmilyday)
    private String name;
    private String tagline;          // 한 줄 소개
    private String period;
    private String role;
    private String emoji;
    private boolean available;       // false면 "준비중"으로 표시, 링크 비활성화
    private List<String> techBadges; // 카드에 표시할 짧은 기술 태그
}
