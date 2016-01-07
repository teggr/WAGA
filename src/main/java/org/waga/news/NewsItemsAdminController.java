package org.waga.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.web.ViewHelper;

@Controller
public class NewsItemsAdminController {

	@Autowired
	private NewsItemRepository newsItemsRepository;

	@ModelAttribute
	public NewsItem newsItem() {
		return new NewsItem();
	}

	@RequestMapping(value = "/admin/news", method = RequestMethod.GET)
	public String newsAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper("venueAdmin"));
		modelMap.addAttribute("newsItems", newsItemsRepository.findAll());
		return "newsAdmin";
	}

	@RequestMapping(value = "/admin/news", method = RequestMethod.POST)
	public String createNewsItem(ModelMap modelMap, @ModelAttribute NewsItem newsItem, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(newsItem);
			return newsAdmin(modelMap);
		}
		
		newsItemsRepository.save(newsItem);

		return "redirect:/admin/news";
	}

	@RequestMapping(value = "/admin/news/{id}", method = RequestMethod.POST)
	public String updateNewsItem(ModelMap modelMap, @PathVariable("id") Long id, @ModelAttribute NewsItem newsItem,
			BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(newsItem);
			return newsAdmin(modelMap);	
		}
		
		NewsItem existing = newsItemsRepository.findOne(id);
		existing.update(newsItem);
		newsItemsRepository.save(existing);
		
//		service.update(id,newsItem);

		return "redirect:/admin/news";
	}

}