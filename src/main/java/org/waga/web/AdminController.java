package org.waga.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String adminHome(ModelMap modelMap) {

		modelMap.addAttribute("helper", new ViewHelper("home"));

		return "admin";
	}

}
