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
import sgn.model.Notifications;
import sgn.model.User;
import sgn.model.dao.CommentDao;
import sgn.model.dao.GroupDao;
import sgn.model.dao.NotificationsDao;
import sgn.model.dao.UserDao;
import sgn.web.validator.NewGroupValidator;

@Controller
public class GroupController {

	@Autowired
	UserDao userDao;

	@Autowired
	GroupDao groupDao;

	@Autowired
	CommentDao commentDao;

	@Autowired
	NewGroupValidator ngv;

	@Autowired
	NotificationsDao ntfDao;

	@RequestMapping(value = "user/groups/newGroup.html", method = RequestMethod.GET)
	public String newGroup(ModelMap map, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";

		map.put("group", new Group());
		return "user/groups/newGroup";
	}

	@RequestMapping(value = "user/groups/newGroup.html", method = RequestMethod.POST)
	public String newGroup(@ModelAttribute("group") Group group,
			BindingResult bindingResult, SessionStatus session,
			HttpServletRequest request) {

		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";

		ngv.validate(group, bindingResult);
		if (bindingResult.hasErrors())
			return "user/groups/newGroup";

		group.setOwnerId((User) request.getSession().getAttribute("user"));

		Group g = groupDao.saveGroup(group);
		User user = (User) request.getSession().getAttribute("user");

		userDao.update(user, g);

		session.setComplete();

		user.setGroups(groupDao.getAll(user));
		request.getSession().setAttribute("user", user);

		return "redirect:/user/profile.html";
	}

	@RequestMapping(value = "user/groups/group.html")
	public String group(@RequestParam("groupId") Integer hiddenGroupId,
			ModelMap map, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";

		boolean isowner = false;
		boolean ingroup = false;

		User user = (User) request.getSession().getAttribute("user");

		List<Comment> comments = commentDao.getComment(hiddenGroupId);
		Group group = groupDao.getGroupById(hiddenGroupId);
		List<User> friends = groupDao.getFriendsInGroup(hiddenGroupId);

		group.setCommets(comments);

		if (user.getId().equals(group.getOwnerId().getId())) {
			isowner = true;
		}

		if (isowner) {
			for (int i = 0; i < friends.size(); i++) {
			
				if (friends.get(i).getId() == user.getId()) {

					friends.remove(i);
					break;
				}

			}
		}

		// friends.remove(friends.indexOf(user));

		ingroup = groupDao.isInGroup(group.getId(), user.getId());

		map.put("group", group);
		map.put("friends", friends);
		map.put("isOwner", isowner);
		map.put("ingroup", ingroup);

		return "user/groups/group";
	}

	@RequestMapping(value = "user/groups/post.html")
	public String post(@RequestParam("groupId") Integer id,
			@RequestParam("posted") String post, HttpServletRequest request,
			ModelMap map) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";

		User user = (User) request.getSession().getAttribute("user");
		Group g = groupDao.getGroupById(id);

		Comment comment = new Comment(g, user, new Timestamp(
				new Date().getTime()), post);

		commentDao.saveComment(comment);

		return "redirect:group.html?groupId=" + id;
	}

	@RequestMapping(value = { "search/addGroup.html",
			"user/groups/addGroup.html" })
	public String addGroup(@RequestParam("groupId") Integer id,
			HttpServletRequest request, ModelMap map) {

		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";

		Group group = groupDao.getGroupById(id);
		User user = (User) request.getSession().getAttribute("user");

		userDao.update(user, group);

		return "redirect:/user/groups/group.html?groupId=" + group.getId();

	}

	@RequestMapping(value = { "search/request.html" })
	public String request(@RequestParam("groupId") Integer id,
			@RequestParam("ownerId") Integer ownerId,
			HttpServletRequest request, ModelMap map) {

		if (request.getSession().getAttribute("user") == null)
			return "redirect:home.html";

		Group group = groupDao.getGroupById(id);
		User friend = userDao.getUser(ownerId);

		User user = (User) request.getSession().getAttribute("user");
		Notifications notify = new Notifications(friend, group, user);

		ntfDao.saveNotification(notify);

		return "redirect:/search/allPriv.html";//"redirect:/user/groups/group.html?groupId=" + id;

	}

	@RequestMapping(value = "user/groups/unfriend.html")
	public String unfriend(@RequestParam("unfriend") Integer id,
			@RequestParam("groupID") Integer gid, HttpServletRequest request,
			ModelMap map) {

		if (request.getSession().getAttribute("user") == null)
			return "redirect:../home.html";

		groupDao.unfriend(gid, id);

		return "redirect:group.html?groupId=" + gid;
	}

}
