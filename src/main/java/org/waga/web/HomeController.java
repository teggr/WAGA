package org.waga.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.waga.news.NewsItemRepository;
import org.waga.rtcb.RaceToCiaoBellaStatsService;
import org.waga.wc.WoodmanCupConstants;
import org.waga.wc.WoodmanCupStatsService;

@RequestMapping("/")
@Controller
public class HomeController {

	@Autowired
	private NewsItemRepository newsItemRepository;

	@Autowired
	private RaceToCiaoBellaStatsService raceToCiaoBellaStatsService;

	@Autowired
	private WoodmanCupStatsService woodmanCupStatsService;

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap modelMap) {

		modelMap.addAttribute("items", newsItemRepository.findFirst10ByOrderByCreatedDateDesc());
		modelMap.addAttribute("rtcbRankings", raceToCiaoBellaStatsService.getRankings());
		modelMap.addAttribute("lastTournament", raceToCiaoBellaStatsService.getLastTournamentSummary());
		modelMap.addAttribute("wcLeaders", woodmanCupStatsService.getLeaders());
		modelMap.addAttribute("helper", new ViewHelper());

		return "home";
	}

	@RequestMapping(value = "/woodmancup", method = RequestMethod.GET)
	public String woodmancup(ModelMap modelMap) {

		modelMap.addAttribute("items",
				newsItemRepository.findFirst10ByTagOrderByCreatedDateDesc(WoodmanCupConstants.NEWS_ITEM_TAG));
		modelMap.addAttribute("rtcbRankings", raceToCiaoBellaStatsService.getRankings());
		modelMap.addAttribute("lastTournament", raceToCiaoBellaStatsService.getLastTournamentSummary());
		modelMap.addAttribute("wcLeaders", woodmanCupStatsService.getLeaders());
		modelMap.addAttribute("helper", new ViewHelper());

		return "home";
	}

}
