package org.waga.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.web.ViewHelper;

@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String newsAdmin(ModelMap modelMap) {
		modelMap.addAttribute("helper", new ViewHelper());
		modelMap.addAttribute("players", playerRepository.findAll());
		return "players";
	}

}
