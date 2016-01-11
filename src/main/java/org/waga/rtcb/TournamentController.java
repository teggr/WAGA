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
import org.waga.player.Player;
import org.waga.player.PlayerRepository;
import org.waga.web.ViewHelper;

@Controller
public class TournamentController {

	@Autowired
	private RaceToCiaoBellaRepository raceRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@ModelAttribute
	public ResultForm resultForm() {
		return new ResultForm();
	}

	@ModelAttribute("players")
	public List<Player> players() {
		return playerRepository.findAll();
	}

	@RequestMapping(value = "/admin/races/{id}/tournaments/{tid}", method = RequestMethod.GET)
	public String tournamentAdmin(@PathVariable("id") Long id, @PathVariable("tid") Long tid, ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper("rtcbAdmin"));
		RaceToCiaoBella race = raceRepository.findOne(id);
		modelMap.addAttribute("race", race);
		modelMap.addAttribute("tournament", race.findTournamentById(tid));
		return "tournamentAdmin";
	}

	@RequestMapping(value = "/admin/races/{id}/tournaments/{tid}", params = { "result" }, method = RequestMethod.POST)
	public String createResult(ModelMap modelMap, @PathVariable("id") Long id, @PathVariable("tid") Long tid,
			@ModelAttribute ResultForm resultForm, BindingResult result) {

		if (result.hasErrors()) {
			return tournamentAdmin(id, tid, modelMap);
		}

		RaceToCiaoBella existing = raceRepository.findOne(id);
		Tournament tournament = existing.findTournamentById(tid);
		Result tourResult = new Result();
		resultForm.update(tourResult);
		tourResult.setPlayer(playerRepository.findOne(resultForm.getPlayerId()));
		tournament.addResult(tourResult);
		raceRepository.save(existing);

		return "redirect:/admin/races/" + id + "/tournaments/" + tid;
	}

	@RequestMapping(value = "/admin/races/{id}/tournaments/{tid}", params = {
			"deleteResult" }, method = RequestMethod.POST)
	public String deleteResult(ModelMap modelMap, @PathVariable("id") Long id, @PathVariable("tid") Long tid,
			@RequestParam("resultId") Long resultId) {

		if (resultId == null) {
			return tournamentAdmin(id, tid, modelMap);
		}

		RaceToCiaoBella existing = raceRepository.findOne(id);
		Tournament tournament = existing.findTournamentById(tid);
		tournament.deleteResult(resultId);
		raceRepository.save(existing);

		return "redirect:/admin/races/" + id + "/tournaments/" + tid;
	}

}
