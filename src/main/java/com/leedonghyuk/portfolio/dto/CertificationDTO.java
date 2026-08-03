package com.leedonghyuk.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificationDTO {
    private String name;    // 자격증명
    private String issuer;  // 발행처
    private String date;    // 취득일 (or "취득 예정" 등)
}
