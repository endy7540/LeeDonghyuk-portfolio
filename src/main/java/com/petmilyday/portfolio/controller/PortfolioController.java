package com.petmilyday.portfolio.controller;

import com.petmilyday.portfolio.data.PortfolioData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioData portfolioData;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("techStacks", portfolioData.techStacks());
        model.addAttribute("caseStudies", portfolioData.caseStudies());
        return "index";
    }
}
