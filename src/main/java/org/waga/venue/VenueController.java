package org.waga.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.web.ViewHelper;

@Controller
public class VenueController {

	@Autowired
	private VenueRepository venueRepository;

	@RequestMapping(value = "/venues", method = RequestMethod.GET)
	public String venues(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper());
		modelMap.addAttribute("venues", venueRepository.findAll());
		return "venues";
	}

}
