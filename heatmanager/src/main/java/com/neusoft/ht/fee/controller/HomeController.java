package com.neusoft.ht.fee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.ht.fee.service.HomeService;

@Controller
public class HomeController {
	
		@Autowired
	    private HomeService homeService;

	    @RequestMapping("/home")
	    public String countryList(Model model) {
	        model.addAttribute("homes", homeService.findAll() );
	        return "homeList";
	    }

	
	

}
