package org.waga.rtcb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.venue.Venue;
import org.waga.venue.VenueRepository;
import org.waga.web.ViewHelper;

@Controller
public class RaceToCiaoBellaAdminController {

	@Autowired
	private RaceToCiaoBellaRepository raceRepository;

	@Autowired
	private VenueRepository venueRepository;

	@ModelAttribute
	public RaceToCiaoBella raceToCiaoBella() {
		return new RaceToCiaoBella();
	}

	@ModelAttribute
	public TournamentForm tournamentForm() {
		return new TournamentForm();
	}

	@ModelAttribute("venues")
	public List<Venue> venues() {
		return venueRepository.findAll();
	}

	@RequestMapping(value = "/admin/rtcb", method = RequestMethod.GET)
	public String rtcbAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper("rtcbAdmin"));
		modelMap.addAttribute("races", raceRepository.findAll());
		return "rtcbAdmin";
	}

	@RequestMapping(value = "/admin/rtcb", method = RequestMethod.POST)
	public String createRace(ModelMap modelMap, @ModelAttribute RaceToCiaoBella raceToCiaoBella, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(raceToCiaoBella);
			return rtcbAdmin(modelMap);
		}

		raceRepository.save(raceToCiaoBella);

		return "redirect:/admin/rtcb";
	}

	@RequestMapping(value = "/admin/rtcb/{id}", method = RequestMethod.POST)
	public String updateRace(ModelMap modelMap, @PathVariable("id") Long id, @ModelAttribute RaceToCiaoBella rtcb,
			BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(rtcb);
			return rtcbAdmin(modelMap);
		}

		RaceToCiaoBella existing = raceRepository.findOne(id);
		existing.update(rtcb);
		raceRepository.save(existing);

		return "redirect:/admin/players";
	}

	@RequestMapping(value = "/admin/rtcb/tournament", method = RequestMethod.POST)
	public String createTournament(ModelMap modelMap, @ModelAttribute TournamentForm tournamentForm,
			BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(tournamentForm);
			return rtcbAdmin(modelMap);
		}

		RaceToCiaoBella race = raceRepository.findOne(tournamentForm.getRaceId());
		Venue venue = venueRepository.findOne(tournamentForm.getVenueId());
		Tournament tour = new Tournament();
		tournamentForm.update(tour);
		tour.setVenue(venue);
		race.addTournaments(tour);

		raceRepository.save(race);

		return "redirect:/admin/rtcb";
	}

}
