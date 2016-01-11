package org.waga.venue;

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
public class VenueAdminController {

	@Autowired
	private VenueRepository venueRepository;

	@ModelAttribute
	public Venue venue() {
		return new Venue();
	}

	@RequestMapping(value = "/admin/venues", method = RequestMethod.GET)
	public String venueAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper("venueAdmin"));
		modelMap.addAttribute("venues", venueRepository.findAll());
		return "venuesAdmin";
	}

	@RequestMapping(value = "/admin/venues", method = RequestMethod.POST)
	public String createVenue(ModelMap modelMap, @ModelAttribute Venue venue, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(venue);
			return venueAdmin(modelMap);
		}

		venueRepository.save(venue);

		return "redirect:/admin/venues";
	}

	@RequestMapping(value = "/admin/venues", method = RequestMethod.POST, params = { "update" })
	public String updateVenue(ModelMap modelMap, @ModelAttribute Venue venue, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(venue);
			return venueAdmin(modelMap);
		}

		Venue existing = venueRepository.findOne(venue.getId());
		existing.update(venue);
		venueRepository.save(existing);

		return "redirect:/admin/venues";
	}

	@RequestMapping(value = "/admin/venues", method = RequestMethod.POST, params = { "remove" })
	public String removeVenue(ModelMap modelMap, @ModelAttribute Venue venue, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(venue);
			return venueAdmin(modelMap);
		}

		venueRepository.delete(venue.getId());

		return "redirect:/admin/venues";
	}

}
