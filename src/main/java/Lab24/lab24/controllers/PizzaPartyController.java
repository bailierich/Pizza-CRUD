package Lab24.lab24.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Lab24.lab24.PartyOptionRepository;
import Lab24.lab24.PartyRepository;
import Lab24.lab24.entity.Party;
import Lab24.lab24.entity.PartyOption;


@Controller
public class PizzaPartyController {
	
	@Autowired
	private PartyRepository pRepository;
	@Autowired
	private PartyOptionRepository pOptionRepository;
	
	@RequestMapping("/")
	public String list(){
		return "redirect:/home";
	}
	
	
	@RequestMapping("/home")
	public String listParties(Model model) {

		List<Party> partyList = pRepository.findAll();
		
		model.addAttribute("partyList", partyList);
		
		return "home";
	}
	@RequestMapping("/home/vote/{id}")
	public String listPizzas(Model model,@PathVariable ("id") Long id) {
		Party party = pRepository.findById(id).orElse(null);
		List<PartyOption> partyOptionList = pOptionRepository.findByPartyId(id);
		
		
		model.addAttribute("partyOption", partyOptionList);
		model.addAttribute("party",party);
		
		return "vote";
	}
	@RequestMapping("/home/vote/submit/{id}")
	public String addVote(Model model,@PathVariable ("id") Long id) {
		PartyOption option = pOptionRepository.findById(id).orElse(null);
		
		Integer currVotes = option.getVotes();
		option.setVotes(currVotes + 1); 
		
		pOptionRepository.save(option);
		;
		
		return "redirect:/home/vote/"+ option.getParty().getId();
		
	}
	
@PostMapping("/home/vote/{id}")
public String addPizza(@PathVariable ("id") Long id,@RequestParam String name, @RequestParam String description) {
	Party party = pRepository.findById(id).orElse(null);
	PartyOption pizza = new PartyOption();
	pizza.setName(name);
	pizza.setDescription(description);
	pizza.setVotes(0);
	pizza.setParty(party);
	
	pOptionRepository.save(pizza);
	
	
	return "redirect:/home/vote/{id}";
	
}
@RequestMapping("/home/review/{id}")
public String createOrderedList(Model model,@PathVariable ("id") Long id) {
	Party party = pRepository.findById(id).orElse(null);
	int i = 0;
	List<PartyOption> partyOptionList = pOptionRepository.findByPartyIdAndVotesGreaterThan(id, i);
	
	
	model.addAttribute("partyOptionList",partyOptionList);
	model.addAttribute("party",party);
	
	return "reviews";
	
	
}
}
