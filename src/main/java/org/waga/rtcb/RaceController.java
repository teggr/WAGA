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
import org.springframework.web.bind.annotation.RequestParam;
import org.waga.venue.Venue;
import org.waga.venue.VenueRepository;
import org.waga.web.ViewHelper;

@Controller
public class RaceController {

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

	@RequestMapping(value = "/admin/races", method = RequestMethod.GET)
	public String racesAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper());
		modelMap.addAttribute("races", raceRepository.findAll());
		return "racesAdmin";
	}

	@RequestMapping(value = "/admin/races", method = RequestMethod.POST)
	public String createRace(ModelMap modelMap, @ModelAttribute RaceToCiaoBella raceToCiaoBella, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(raceToCiaoBella);
			return racesAdmin(modelMap);
		}

		RaceToCiaoBella saved = raceRepository.save(raceToCiaoBella);

		return "redirect:/admin/races/" + saved.getId();
	}

	@RequestMapping(value = "/admin/races", method = RequestMethod.POST, params = { "remove" })
	public String removeRace(ModelMap modelMap, @RequestParam("raceId") Long id) {

		raceRepository.delete(id);

		return "redirect:/admin/races";
	}

	@RequestMapping(value = "/admin/races/{id}", method = RequestMethod.GET)
	public String raceAdmin(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper());
		modelMap.addAttribute("races", raceRepository.findAll());
		modelMap.addAttribute("race", raceRepository.findOne(id));
		return "raceAdmin";
	}

	@RequestMapping(value = "/admin/races/{id}", method = RequestMethod.POST)
	public String updateRace(ModelMap modelMap, @PathVariable("id") Long id, @ModelAttribute RaceToCiaoBella rtcb,
			BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(rtcb);
			return raceAdmin(id, modelMap);
		}

		RaceToCiaoBella existing = raceRepository.findOne(id);
		existing.update(rtcb);
		RaceToCiaoBella saved = raceRepository.save(existing);

		return "redirect:/admin/races/" + saved.getId();
	}

	@RequestMapping(value = "/admin/races/{id}", method = RequestMethod.POST, params = { "remove" })
	public String removeTournament(ModelMap modelMap, @PathVariable("id") Long id,
			@RequestParam("tournamentId") Long tid) {

		RaceToCiaoBella race = raceRepository.findOne(id);
		race.removeTournament(tid);
		raceRepository.save(race);

		return "redirect:/admin/races/ " + id;
	}

	@RequestMapping(value = "/admin/races/{id}", params = { "tournament" }, method = RequestMethod.POST)
	public String createTournament(ModelMap modelMap, @PathVariable("id") Long id,
			@ModelAttribute TournamentForm tournamentForm, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(tournamentForm);
			return raceAdmin(id, modelMap);
		}

		RaceToCiaoBella race = raceRepository.findOne(id);
		Venue venue = venueRepository.findOne(tournamentForm.getVenueId());
		Tournament tour = new Tournament();
		tournamentForm.update(tour);
		tour.setVenue(venue);
		race.addTournaments(tour);

		RaceToCiaoBella saved = raceRepository.save(race);
		Tournament savedTour = saved.findTournamentByName(tour.getName());

		return "redirect:/admin/races/" + saved.getId() + "/tournaments/" + savedTour.getId();
	}

}
