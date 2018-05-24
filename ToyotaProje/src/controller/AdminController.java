package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Kullanici;
import domain.Role;
import domain.Servis;
import domain.Seyahat;
import formModel.SearchSeyahat;
import service.KullaniciServiceImpl;
import service.SeyahatServiceImpl;
import validator.MyProfileValidator;
import validator.SearchDateValidator;
import validator.SeyahatValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private KullaniciServiceImpl kullaniciService;
	@Autowired
	private SeyahatServiceImpl seyahatService;
	@Autowired
	private SeyahatValidator seyahatValidator;
	@Autowired
	private SearchDateValidator searchValidator;
	@Autowired
	private MyProfileValidator myProfileValidator;
	
	private List<Seyahat> travelListForExcel=new ArrayList<Seyahat>();
	
	
	//--------------------- USER HANDLING -------------------------------------------------------------------------------------
	
	@RequestMapping(value="/listUser",method=RequestMethod.GET)
	public String ListUser(Model model) {
		 model.addAttribute("allUsers", kullaniciService.getKullanicis());
		return "users";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
    // http://localhost:8080/../admin/addUser
	public String getNewUserForm(@ModelAttribute("newUser") Kullanici newUser) {
		return "/userAddAdmin";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String processAddNewUser(@ModelAttribute("newUser") Kullanici userToBeAdded,BindingResult bindingResult) {
		System.out.println(userToBeAdded);
		

		//Validation
		myProfileValidator.validate(userToBeAdded,bindingResult);
	    if (bindingResult.hasErrors()) {
			return "/userAddAdmin";
			}
		
		kullaniciService.addKullanici(userToBeAdded);
		return "redirect:/admin/listUser";
	}
	
	@RequestMapping(value="/updateUser{userId}",method=RequestMethod.GET)
	public String updateUser(@RequestParam("userId") int id, Model model) {	
		model.addAttribute("updateUser",kullaniciService.getKullaniciById(id));
		
		return "/userUpdateAdmin";
	}
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUserPost(@ModelAttribute("updateUser") Kullanici updatedUser,BindingResult bindingResult) {
		System.out.println("Admin#UpdateUserPost: "+updatedUser);
		//Validation
		myProfileValidator.validate(updatedUser,bindingResult);
			if (bindingResult.hasErrors()) {
			return "/userUpdateAdmin";
			}
		
		kullaniciService.updateKullanici(updatedUser);
		return "redirect:/admin/listUser";
	}
	
	@RequestMapping(value="/deleteUser{userId}",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam("userId") int id) {	
		kullaniciService.deleteKullanici(id);
		return "redirect:/admin/listUser";
	}
	
	@RequestMapping(value="/updateMyProfile",method=RequestMethod.GET)
	public String updateMyProfile(HttpServletRequest request, Model model) {	
		int id=(Integer)request.getSession().getAttribute("userId");
		model.addAttribute("updateUser",kullaniciService.getKullaniciById(id));
		return "/updateMyProfileAdmin";
	}
	
	@RequestMapping(value="/updateMyProfile",method=RequestMethod.POST)
	public String updateMyProfilePost(@ModelAttribute("updateUser") Kullanici updatedUser,BindingResult bindingResult) {
		
		//Validation
		myProfileValidator.validate(updatedUser,bindingResult);
	    if (bindingResult.hasErrors()) {
			return "/updateMyProfileAdmin";
			}
		
		kullaniciService.updateMyProfile(updatedUser);
		return "redirect:/admin/listUser";
	}
	
	
	
	
	
	
	//------------ TRAVEL HANDLING -----------------------------------------------------------------------------------------------
	
	@RequestMapping(value="/listTravel", method=RequestMethod.GET)
    // http://localhost:8080/../admin/listTravel
	public String ListSeyahat( Model model) {
		SearchSeyahat searchSeyahat=new SearchSeyahat();
		model.addAttribute("searchTravel",searchSeyahat );
		model.addAttribute("allTravels", seyahatService.getAllSeyahatLastXMonth(12));
		travelListForExcel=seyahatService.getAllSeyahatLastXMonth(12);
		return "/travelsAdmin";
	}
	
	@RequestMapping(value="/listTravel",method=RequestMethod.POST)
    // http://localhost:8080/../admin/listTravel
	public String serachedTravelList(@ModelAttribute("searchTravel") SearchSeyahat searchedTravel ,Model model,BindingResult bindingResult) {
		//Validation
		searchValidator.validate(searchedTravel,bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("allTravels", seyahatService.getAllSeyahatLastXMonth(12));
			travelListForExcel=seyahatService.getAllSeyahatLastXMonth(12);
			return "/travelsAdmin";
		}
		
		seyahatService.searchSeyahat(searchedTravel);
		model.addAttribute("allTravels", seyahatService.searchSeyahat(searchedTravel));
		travelListForExcel=seyahatService.searchSeyahat(searchedTravel);
		return "/travelsAdmin";
	}
	//Excel--------
	@RequestMapping(value = "/excelExport", method = { RequestMethod.POST })
	public ModelAndView excelExport( HttpServletResponse response) {

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=SeyahatListesi.xls");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("excelView");
		mv.addObject("travels",travelListForExcel );
		return mv;
	}
	
	
	@RequestMapping(value = "/addTravel", method = RequestMethod.GET)
    // http://localhost:8080/../admin/addTravel
	public String getNewAddTravelForm(@ModelAttribute("newTravel") Seyahat newTravel) {
		return "/travelAddAdmin";
	}
	
	@RequestMapping(value = "/addTravel", method = RequestMethod.POST)
    // http://localhost:8080/../admin/addTravel
	public String processAddNewTravelForm(@ModelAttribute("newTravel") Seyahat travelToBeAdded,BindingResult bindingResult) {
		System.out.println(travelToBeAdded);
		
		seyahatValidator.validate(travelToBeAdded,bindingResult);
		if (bindingResult.hasErrors()) {
			return "/travelAddAdmin";
		}
		
		seyahatService.addSeyahat(travelToBeAdded);
		return "redirect:/admin/listTravel";
	}
	
	@RequestMapping(value="/updateTravel{travelId}",method=RequestMethod.GET)
    // http://localhost:8080/../admin/updateTravel?travelId=X
	public String updateTravel(@RequestParam("travelId") int id, Model model) {	
		model.addAttribute("updateTravel",seyahatService.getSeyahatByIdForUpdate(id));
		return "/travelUpdateAdmin";
	}
	
	@RequestMapping(value="/updateTravel",method=RequestMethod.POST)
    // http://localhost:8080/../admin/updateTravel
	public String updateTravelPost(@ModelAttribute("updateTravel") Seyahat updatedTravel,BindingResult bindingResult) {
		System.out.println("UpdateTravelPost working!!"+updatedTravel);
		
		seyahatValidator.validate(updatedTravel,bindingResult);
		if (bindingResult.hasErrors()) {
			return "/travelUpdateAdmin";
		}
		
		seyahatService.updateSeyahat(updatedTravel);
		return "redirect:/admin/listTravel";
	}
	
	@RequestMapping(value="/deleteTravel{travelId}",method=RequestMethod.GET)
    // http://localhost:8080/../admin/deleteTravel?travelId=X
	public String deleteTravel(@RequestParam("travelId") int id) {	
		seyahatService.deleteSeyahat(id);
		return "redirect:/admin/listTravel";
	}
	
	


	
	

	
	
	
	
	
	//----------------@ModelAttribute-----------------------------
	
	
	@ModelAttribute("roleList")
	public List<Role> prepareroleList() {
	List<Role> roleList=new ArrayList<Role>();	
	for(Role role: Role.values()) {
		roleList.add(role);
		}
	return roleList;
	}
	
	@ModelAttribute("servisList")
	public List<Servis> prepareServisList(){
		List<Servis> servisList=new ArrayList<Servis>();
		for(Servis s: Servis.values()) {
			servisList.add(s);
		}
	return servisList;
	}

	@ModelAttribute("userNameList")
	public List<String> prepareUserNameList() {
		List<String> userListName=new ArrayList<String>();
		 for(Kullanici kul :kullaniciService.getKullanicis()) {
			 userListName.add(kul.getKullaniciAdi());
		 }
		 return userListName;
	}

	
	
}
