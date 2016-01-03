package org.waga.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
