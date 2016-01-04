package org.waga.rtcb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.news.NewsItemRepository;
import org.waga.web.ViewHelper;

@RequestMapping("/racetociaobella")
@Controller
public class RaceToCiaoBellaController {

	@Autowired
	private NewsItemRepository newsItemRepository;

	@Autowired
	private RaceToCiaoBellaStatsService raceToCiaoBellaStatsService;

	@RequestMapping(method = RequestMethod.GET)
	public String racetociaobella(ModelMap modelMap) {

		modelMap.addAttribute("items",
				newsItemRepository.findFirst10ByTagOrderByCreatedTimeDesc(RaceToCiaoBellaConstants.NEWS_ITEM_TAG));
		modelMap.addAttribute("lastTournament", raceToCiaoBellaStatsService.getLastTournamentSummary());
		modelMap.addAttribute("rtcbRankings", raceToCiaoBellaStatsService.getRankings());
		modelMap.addAttribute("helper", new ViewHelper("rtcb"));

		return "rtcb";
	}

}
