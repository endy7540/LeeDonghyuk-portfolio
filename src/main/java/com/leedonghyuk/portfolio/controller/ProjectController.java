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

    @GetMapping("/projects/planslot")
    public String planslot(Model model) {
        model.addAttribute("project", portfolioData.planslotDetail());
        return "project-detail";
    }
}