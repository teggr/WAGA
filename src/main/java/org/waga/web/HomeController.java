package org.waga.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.news.NewsItemRepository;

@RequestMapping("/")
@Controller
public class HomeController {
	
	@Autowired
	private NewsItemRepository newsItemRepository;

	@RequestMapping(method=RequestMethod.GET)
	public String home(ModelMap modelMap) {
		
		modelMap.addAttribute("items", newsItemRepository.findFirst10ByCreatedDateDesc() );
		modelMap.addAttribute("helper", new ViewHelper());
		
		return "home";
	}
	
}
