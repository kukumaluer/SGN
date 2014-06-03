package sgn.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sgn.model.Group;
import sgn.model.User;
import sgn.model.dao.GroupDao;


@Controller
public class SearchController {

	@Autowired
	GroupDao groupDao;
	
	
	@RequestMapping(value = {"search/allPublic.html"})
	public String allPublic(ModelMap map, HttpServletRequest request )
	{
		
		
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		List<Group> groups = null;
		List<Group> groups2 = new ArrayList<Group>();
		List<Group> groups3 = new ArrayList<Group>();
		
		User user = (User)request.getSession().getAttribute("user");
		
		//groups = groupDao.getAllExceptinGroup(user);
		groups = groupDao.getGroupsIamIn(new Group(), user);
		groups2 = groupDao.getAll(true);
		
		
		for(int i = 0; i < groups2.size(); i++ )
		{
			if(!(groups.contains(groups2.get(i))))
			{
				groups3.add(groups2.get(i));
			}
		}
		
		
		map.put("allGroups", groups3);
		
		
		return "search/allPublic";
	}
	
	
	@RequestMapping(value = {"search/allPriv.html"})
	public String allPriv(ModelMap map, HttpServletRequest request )
	{
		
		
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		List<Group> groups = null;
		List<Group> groups2 = new ArrayList<Group>();
		List<Group> groups3 = new ArrayList<Group>();
		List<Group> groups4 = new ArrayList<Group>();
		List<Group> groups5 = new ArrayList<Group>();
		User user = (User)request.getSession().getAttribute("user");
		
		//groups = groupDao.getAllExceptinGroup(user);
		groups = groupDao.getGroupsIamIn(new Group(), user);
		groups2 = groupDao.getAll(false);
		groups4 = groupDao.getGroupsIamInPriv(user);
		
		
		for(int i = 0; i < groups2.size(); i++ )
		{
			if(!(groups.contains(groups2.get(i))))
			{
				groups3.add(groups2.get(i));
			}
		}
		for(int i = 0; i < groups3.size(); i++ )
		{
			if(!(groups4.contains(groups3.get(i))))
			{
				groups5.add(groups3.get(i));
			}
		}
		
		
		
		
		map.put("allGroups", groups5);
		
		
		return "search/allPriv";
	}
	

	
	
	
	
	
	
}
