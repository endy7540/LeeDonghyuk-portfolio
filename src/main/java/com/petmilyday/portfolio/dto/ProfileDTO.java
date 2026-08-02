package com.petmilyday.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private String name;         // 이름
    private String tagline;      // 한 줄 소개 (ex. "혁신을 꿈꾸는 백엔드 개발자")
    private String bio;          // 짧은 자기소개 문단
    private String email;
    private String github;
    private String phone;
}
