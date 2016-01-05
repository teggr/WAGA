package org.waga.core;

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
public class PlayerAdminController {

	@Autowired
	private PlayerRepository playerRepository;

	@ModelAttribute
	public Player player() {
		return new Player();
	}

	@RequestMapping(value = "/admin/players", method = RequestMethod.GET)
	public String playerAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper("playerAdmin"));
		modelMap.addAttribute("players", playerRepository.findAll());
		return "playersAdmin";
	}

	@RequestMapping(value = "/admin/players", method = RequestMethod.POST)
	public String createPlayer(ModelMap modelMap, @ModelAttribute Player player, BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(player);
			return playerAdmin(modelMap);
		}

		playerRepository.save(player);

		return "redirect:/admin/players";
	}

	@RequestMapping(value = "/admin/players/{id}", method = RequestMethod.POST)
	public String updatePlayer(ModelMap modelMap, @PathVariable("id") Long id, @ModelAttribute Player player,
			BindingResult result) {

		if (result.hasErrors()) {
			modelMap.addAttribute(player);
			return playerAdmin(modelMap);
		}

		Player existing = playerRepository.findOne(id);
		existing.update(player);
		playerRepository.save(existing);

		return "redirect:/admin/players";
	}

}
