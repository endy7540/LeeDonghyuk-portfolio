package com.petmilyday.portfolio.controller;

import com.petmilyday.portfolio.data.PortfolioData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PortfolioData portfolioData;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projects", portfolioData.projectSummaries());
        model.addAttribute("techStacks", portfolioData.overallTechStacks());
        model.addAttribute("featured", portfolioData.featuredProject());
        model.addAttribute("educations", portfolioData.educations());
        model.addAttribute("certifications", portfolioData.certifications());
        return "index";
    }
}
