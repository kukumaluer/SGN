package sgn.web.controller;

import java.sql.Timestamp;
import java.util.Date;
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

import sgn.model.Comment;
import sgn.model.Group;
import sgn.model.User;
import sgn.model.dao.CommentDao;
import sgn.model.dao.GroupDao;
import sgn.model.dao.UserDao;

@Controller
public class GroupController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	GroupDao groupDao;
	
	@Autowired
	CommentDao commentDao;
	
	
	@RequestMapping(value = "user/groups/newGroup.html", method = RequestMethod.GET)
	public String newGroup(ModelMap map, HttpServletRequest request )
	{
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		map.put("group", new Group());
		return "user/groups/newGroup";
	}
	
	
	@RequestMapping(value = "user/groups/newGroup.html", method = RequestMethod.POST)
	public String newGroup(@ModelAttribute("group") Group group, BindingResult bindingResult,
			SessionStatus session, HttpServletRequest request)
	{
		
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		
		group.setOwnerId((User)request.getSession().getAttribute("user"));
		//group.setPublic(true);
		Group g = groupDao.saveGroup(group);
		User user = (User)request.getSession().getAttribute("user");
		
		
		userDao.update(user,g );
		
		
		session.setComplete();
		
		user.setGroups(groupDao.getAll(user));
		request.getSession().setAttribute("user", user);
		
		
		
		return "redirect:/user/profile.html";
	}
	
	@RequestMapping(value="user/groups/group.html" )
	public String group(@RequestParam("groupId") Integer hiddenGroupId, ModelMap map,
			HttpServletRequest request)
	{
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		boolean isowner = false;
		User user = (User) request.getSession().getAttribute("user");

		//		@RequestParam("hiddenGroupId") Integer hiddenGroupId,
//		Integer hiddenGroupId = Integer.parseInt(request.getParameter("hiddenGroupId"));
		
		System.out.println("hiddenGroupId  "  + hiddenGroupId);
		List<Comment> comments = commentDao.getComment(hiddenGroupId);
		Group group = groupDao.getGroupById(hiddenGroupId);
		List<User> friends = groupDao.getFriendsInGroup(hiddenGroupId);
		
		group.setCommets(comments);
		
		if(user.getId().equals(group.getOwnerId().getId()))
		{
			isowner = true;
		}
		
		map.put("group", group);
		map.put("friends", friends);
		map.put("isOwner", isowner);
		
		return "user/groups/group";
	}
	
	
	@RequestMapping(value= "user/groups/post.html")
	public String post(@RequestParam("groupId") Integer id, 
			@RequestParam("posted") String post,
			HttpServletRequest request, ModelMap map )
	{
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		
		User user = (User) request.getSession().getAttribute("user");
		Group g = groupDao.getGroupById(id);
		
		
		
		Comment comment = new Comment(g,user, new Timestamp(new Date().getTime()), post);
		
		commentDao.saveComment(comment);
		
		
		return "redirect:group.html?groupId="+id;
	}
	
	
	@RequestMapping(value="search/addGroup.html")
	public String addGroup(@RequestParam("groupId") Integer id,
			HttpServletRequest request, ModelMap map)
	{
		
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";
		
		Group group = groupDao.getGroupById(id);
		User user = (User) request.getSession().getAttribute("user");
		
		
		userDao.update(user, group);

		
		return "redirect:/user/profile.html";
		
	}
	
	
	@RequestMapping(value="user/groups/unfriend.html")
	public String unfriend(@RequestParam("unfriend") Integer id,
			@RequestParam("groupID") Integer gid,
			HttpServletRequest request, ModelMap map)
	{
		groupDao.unfriend(gid, id);
		
		return "redirect:group.html?groupId="+gid;
	}
	
	
}
