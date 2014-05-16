package sgn.web.controller;

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
public class GroupController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GroupDao groupDao;
	
	
	@RequestMapping(value = "user/groups/newGroup.html", method = RequestMethod.GET)
	public String newGroup(ModelMap map, HttpServletRequest request )
	{
		map.put("group", new Group());
		return "user/groups/newGroup";
	}
	
	
	@RequestMapping(value = "user/groups/newGroup.html", method = RequestMethod.POST)
	public String newGroup(@ModelAttribute("group") Group group, BindingResult bindingResult,
			SessionStatus session, HttpServletRequest request)
	{
		group.setOwnerId((User)request.getSession().getAttribute("user"));
		group.setPublic(true);
		groupDao.saveGroup(group);
		User user = (User)request.getSession().getAttribute("user");
		session.setComplete();
		
		user.setGroups(groupDao.getAll(user));
		request.getSession().setAttribute("user", user);
		
		
		
		return "redirect:/user/profile.html";
	}
	
	@RequestMapping(value="user/groups/group.html")
	public String group(@RequestParam("groupId") Integer groupId, ModelMap map,
			HttpServletRequest request)
	{
		
		return "group";
	}
	
	
	
}
