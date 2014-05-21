package sgn.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import sgn.model.Group;
import sgn.model.User;
import sgn.model.dao.GroupDao;
import sgn.model.dao.UserDao;


@Controller
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	GroupDao groupDao;
	

    @RequestMapping("/home.html")
    public String index()
    {
        return "home";
    }
    
    @RequestMapping(value = "/NewAcc.html", method = RequestMethod.POST)
    public String newAcc(@ModelAttribute("user") User user,
    		BindingResult bindingResult, SessionStatus session,
    		HttpServletRequest request){

    	//Validate the user if he has an account.
    	//Validate that all the information on the form is completed
    	if (request.getSession().getAttribute("user") != null)
			return "redirect:home.html";

    	
    	User u = userDao.saveUser(user);
    	session.setComplete();
    	request.getSession().setAttribute("user", u);
    	
    	
    	return "redirect:user/profile.html";
    }
    
    @RequestMapping(value ="/NewAcc.html", method = RequestMethod.GET)
    public String newAcc(ModelMap models, HttpServletRequest request)
    {
    	if (request.getSession().getAttribute("user") != null)
			return "redirect:home.html";
    	
    	models.put("user", new User());
    	
    	return "NewAcc";
    }
    
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String signin(ModelMap map, HttpServletRequest request){
    	//Check if the user is already log in.
    	//If the user is log in then redirect him to 
    	//the home page.
    	if (request.getSession().getAttribute("user") != null)
			return "redirect:home.html";
    	
    	map.put("users",new User());
    	return "login";
    	
    }
    
    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String sigin(@ModelAttribute("users") User user, 
    		@RequestParam String email, @RequestParam String password,
    		SessionStatus sessionStatus, HttpServletRequest request,
    		Principal principal) throws Exception
    {
    	
    	if (request.getSession().getAttribute("user") != null)
			return "redirect:home.html";
    	
    	
    	user = userDao.getUser(email, password);
    	
    	System.out.println("sigin " + user.getFirstName());
    	user.setGroups(groupDao.getAll(user));
    	
    	request.getSession().setAttribute("user", user);
    	
    	
    	
    	return "redirect:user/profile.html";
    }
    
    @RequestMapping(value ="user/profile.html", method = RequestMethod.GET)
    public String profile(ModelMap map, HttpServletRequest request){
    	
    	
    	if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
    	
    	
    	User user = (User) request.getSession().getAttribute("user");
    	
    	List<Group> inGroup = new ArrayList<Group>();
    	if(request.getSession().getAttribute("user")!= null){
    		
    		List<Group> inGroups = groupDao.getGroupsIamIn(new Group(), user); 
    		for(int i = 0; i < inGroups.size(); i++)
    		{
    			if(!(inGroup.contains(inGroups.get(i))))
    			{
    				inGroup.add(inGroups.get(i));
    			}
    			
    		}
    		map.put("inGroups", inGroup);
    		return "user/profile";
    	}
    		
    		
    	return "redirect:/home.html";
    }
    
    @RequestMapping("user/logout.html")
    public String logout(SessionStatus sessionStatus,
    		HttpServletRequest request){
    	sessionStatus.setComplete();
    	request.getSession().invalidate();
    	return "redirect:/home.html";
    	
    }
    
    
    

}