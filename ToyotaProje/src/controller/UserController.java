package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Kullanici;
import domain.Servis;
import domain.Seyahat;
import formModel.SearchSeyahat;
import service.KullaniciServiceImpl;
import service.SeyahatServiceImpl;
import validator.MyProfileValidator;
import validator.SearchDateValidator;
import validator.SeyahatValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private KullaniciServiceImpl kullaniciService;
	@Autowired
	private SeyahatServiceImpl seyahatService;
	
	@Autowired
	private SeyahatValidator userSeyahatValidator;
	@Autowired
	private MyProfileValidator myProfileValidator;
	@Autowired
	private SearchDateValidator searchValidator;

	//------ For Travel Controller ------------------------------------
	
	@RequestMapping(value="myTravelList",method=RequestMethod.GET)
	// http://localhost:8080/../user/myTravelList
	public String ListMyTravelsLastTwoMonth(HttpServletRequest request,Model model) {
		SearchSeyahat searchSeyahat=new SearchSeyahat();
		int id=(Integer)request.getSession().getAttribute("userId");
		model.addAttribute("allTravels", seyahatService.getMySeyahatList(2, id));
		model.addAttribute("searchTravel",searchSeyahat );
		return "myTravels";
	}
	
	@RequestMapping(value="/myTravelList",method=RequestMethod.POST)
    // http://localhost:8080/../user/myTravelList
	public String serachedTravelList(@ModelAttribute("searchTravel") SearchSeyahat searchedTravel ,HttpServletRequest request,Model model,BindingResult bindingResult) {
		int id=(Integer)request.getSession().getAttribute("userId");
		searchValidator.validate(searchedTravel,bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("allTravels", seyahatService.getMySeyahatList(2, id));
			return "/myTravels";
		}
		
		seyahatService.searchSeyahat(searchedTravel);
		model.addAttribute("allTravels", seyahatService.searchSeyahat(searchedTravel));
		return "/myTravels";
	}
	
	@RequestMapping(value = "/addTravel", method = RequestMethod.GET)
    // http://localhost:8080/../user/addTravel
	public String getNewAddTravelForm(@ModelAttribute("newTravel") Seyahat newTravel) {
		return "/addMyTravel";
	}
	
	@RequestMapping(value = "/addTravel", method = RequestMethod.POST)
    // http://localhost:8080/../user/addTravel
	public String processAddNewTravelForm(@ModelAttribute("newTravel") Seyahat travelToBeAdded, BindingResult bindingResult) {
		System.out.println(travelToBeAdded);
		
		userSeyahatValidator.validate(travelToBeAdded,bindingResult);
		if (bindingResult.hasErrors()) {
			return "/addMyTravel";
		}
		
		seyahatService.addSeyahat(travelToBeAdded);
		return "redirect:/user/myTravelList";
	}
	
	@RequestMapping(value="/updateTravel{travelId}",method=RequestMethod.GET)
    // http://localhost:8080/../user/updateTravel?travelId=X
	public String updateTravel(@RequestParam("travelId") int id, Model model) {	
		model.addAttribute("updateTravel",seyahatService.getSeyahatByIdForUpdate(id));
		return "/travelUpdateUser";
	}
	
	@RequestMapping(value="/updateTravel",method=RequestMethod.POST)
    // http://localhost:8080/../user/updateTravel
	public String updateTravelPost(@ModelAttribute("updateTravel") Seyahat updatedTravel,BindingResult bindingResult) {
		System.out.println("UpdateTravelPost working!!"+updatedTravel);
		
		userSeyahatValidator.validate(updatedTravel,bindingResult);
		if (bindingResult.hasErrors()) {
			return "/travelUpdateUser";
		}
		
		seyahatService.updateSeyahat(updatedTravel);
		return "redirect:/user/myTravelList";
	}
	
	@RequestMapping(value="/deleteTravel{travelId}",method=RequestMethod.GET)
    // http://localhost:8080/../user/deleteTravel?travelId=X
	public String deleteTravel(@RequestParam("travelId") int id) {	
		seyahatService.deleteSeyahat(id);
		return "redirect:/user/myTravelList";
	}
	
	//------ For User Controller ------------------------------------
	
	@RequestMapping(value="/updateMyProfile",method=RequestMethod.GET)
	public String updateMyProfile(HttpServletRequest request, Model model) {	
		int id=(Integer)request.getSession().getAttribute("userId");
		model.addAttribute("updateUser",kullaniciService.getKullaniciById(id));
		return "/updateMyProfile";
	}
	
	@RequestMapping(value="/updateMyProfile",method=RequestMethod.POST)
	public String updateMyProfilePost(@ModelAttribute("updateUser") Kullanici updatedUser,BindingResult bindingResult) {
		//Validation
		myProfileValidator.validate(updatedUser,bindingResult);
		if (bindingResult.hasErrors()) {
			return "/updateMyProfile";
		}
		
		kullaniciService.updateMyProfile(updatedUser);
		return "redirect:/user/myTravelList";
	}
	
	
	// ---------------- @ModelAttribute -----------------------------
	
	@ModelAttribute("servisList")
	public List<Servis> prepareServisList(){
		List<Servis> servisList=new ArrayList<Servis>();
		for(Servis s: Servis.values()) {
			servisList.add(s);
		}
	return servisList;
	}

	
}
