package org.waga.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.web.ViewHelper;

@Controller
public class NewsItemController {

	@Autowired
	private NewsItemRepository newsItemRepository;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String newsAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper("news"));
		modelMap.addAttribute("items", newsItemRepository.findFirst10ByOrderByCreatedDateDesc());
		return "news";
	}

}
