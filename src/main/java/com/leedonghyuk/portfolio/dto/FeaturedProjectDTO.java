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
public class FeaturedProjectDTO {
    private String badge;           // ex. "Featured · Web"
    private String name;
    private String tagline;         // 한 줄 소개 (screenshot 위 큰 문구)
    private String urlLabel;        // 브라우저 프레임 주소창에 표시할 텍스트 (ex. "localhost:8080")
    private String screenshotUrl;   // null이면 플레이스홀더 표시
    private List<String> highlights; // 핵심 기능 bullet
    private String detailUrl;       // 상세보기(내부 페이지) 링크
    private String repoUrl;         // GitHub 링크 (없으면 null)
}
