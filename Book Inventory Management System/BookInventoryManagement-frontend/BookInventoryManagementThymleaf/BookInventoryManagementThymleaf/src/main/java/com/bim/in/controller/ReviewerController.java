package com.bim.in.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bim.in.pojo.ReviewerPojo;
import com.bim.in.service.ReviewerService;

@Controller
public class ReviewerController {
	@Autowired
	private ReviewerService reviewerService;
	@GetMapping("/reviewer")
	public String getAllReviewer(Model model) {
		List<ReviewerPojo> reviewer= reviewerService.getAllReviewer();
		if (reviewer == null) {
           reviewer = new ArrayList<>();
        }
		model.addAttribute("reviewer",reviewer);
		return "reviewer";
	}
	@GetMapping("/reviewer/new")
    public String showReviewerForm(Model model) {
        model.addAttribute("reviewer", new ReviewerPojo());
        return "addReviewer"; 
    }
	@PostMapping("/reviewer")
	    public String saveReviewer(@Validated @ModelAttribute("reviewer") ReviewerPojo reviewer) {

	        reviewerService.saveReviewer(reviewer);
	        return "redirect:/reviewer";
	}
}
