package com.leedonghyuk.portfolio.controller;

import com.leedonghyuk.portfolio.data.PortfolioData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final PortfolioData portfolioData;

    @GetMapping("/projects/petmilyday")
    public String petmilyday(Model model) {
        model.addAttribute("project", portfolioData.petmilydayDetail());
        return "project-detail";
    }

    // 널모아 준비되면 아래처럼 추가하면 됩니다.
    //
    // @GetMapping("/projects/nulmoa")
    // public String nulmoa(Model model) {
    //     model.addAttribute("project", portfolioData.nulmoaDetail());
    //     return "project-detail";
    // }
}
