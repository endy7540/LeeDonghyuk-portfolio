package com.leedonghyuk.portfolio.config;

import com.leedonghyuk.portfolio.data.PortfolioData;
import com.leedonghyuk.portfolio.dto.ProfileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 헤더/푸터 등 모든 페이지에서 공통으로 쓰는 프로필(이름/연락처) 정보를
 * 매번 컨트롤러마다 model에 넣지 않아도 되도록 전역으로 주입한다.
 */
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalModelAttributes {

    private final PortfolioData portfolioData;

    @ModelAttribute("profile")
    public ProfileDTO profile() {
        return portfolioData.profile();
    }
}
