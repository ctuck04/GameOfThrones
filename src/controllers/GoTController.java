package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Char;
import data.CharDAO;


@Controller
@SessionAttributes("current")
public class GoTController {
	@Autowired
	private CharDAO charDao;

	@ModelAttribute("current")
	public Integer initSessionObject() {
		return 1;
	}
	
	@RequestMapping(path="GetFamily.do", 
			params="family",
			method=RequestMethod.GET)
	public ModelAndView getByName(@RequestParam("family") String c) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultsPage.jsp");
		
		mv.addObject("family", charDao.getCharactersByLastName(c));
		return mv;
	}
	
	@RequestMapping(path="NewCharacter.do",
			method=RequestMethod.POST)
	public ModelAndView newCharacter(Char character) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultsPage.jsp");
		mv.addObject("family", charDao.addCharacter(character));
		return mv;
	}

	@RequestMapping(path="RemoveCharacter.do",
			method=RequestMethod.POST)
	public ModelAndView removeCharacter(String firstName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		mv.addObject("remove", charDao.removeCharacter(firstName));
		return mv;
	}
//	
//	@RequestMapping(path="navigate.do", params="next", method=RequestMethod.GET)
//	public ModelAndView next(@ModelAttribute("current") Integer current) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("results.jsp");
//		mv.addObject("current", ++current);
//		Char c = charDAO.getStateById(current);
//		mv.addObject("character", c);
//		return mv;
//	}

	@RequestMapping(path="editCharacter.do", params={"firstName","lastName", "gender", "status"}, 
			method=RequestMethod.GET)
	public ModelAndView editCharacterGet(String firstName, String lastName, String gender, String status) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit.jsp");
		mv.addObject("fn", firstName);
		mv.addObject("ln", lastName);
		mv.addObject("g", gender);
		mv.addObject("st", status);
		return mv;
	}
	

	@RequestMapping(path="editCharacter.do", params={"firstName","lastName", "gender", "status", "oldFirstName"}, 
			method=RequestMethod.POST)
	public ModelAndView editCharacter(String firstName, String lastName, String gender, String status, String oldFirstName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		mv.addObject("edit", charDao.updateCharacter(firstName, lastName, gender, status, oldFirstName));
		return mv;
	}
	

}

