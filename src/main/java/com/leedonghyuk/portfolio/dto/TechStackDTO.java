package com.leedonghyuk.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechStackDTO {
    private String category;   // Language / Back-end / DB / Infra 등
    private String name;       // Java, Spring Boot, QueryDSL ...
    private String desc;       // 한 줄 설명
}
