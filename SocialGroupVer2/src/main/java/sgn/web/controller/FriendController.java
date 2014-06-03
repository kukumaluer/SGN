package sgn.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgn.model.Group;
import sgn.model.User;
import sgn.model.dao.GroupDao;
import sgn.model.dao.UserDao;

@Controller
public class FriendController {

	@Autowired
	GroupDao groupDao;

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "user/viewfriend.html")
	public String viewFriend(ModelMap map, HttpServletRequest request,
			@RequestParam("fdId") String fdId) {
		Integer id = Integer.parseInt(fdId);

		if (request.getSession().getAttribute("user") == null)
			return "redirect:../home.html";

		User user = userDao.getUser(id);

		List<Group> inGroup = new ArrayList<Group>();
		List<Group> ownerG = groupDao.getOwnerGroups(user);

		List<Group> inGroups = groupDao.getGroupsIamIn(new Group(), user);
		for (int i = 0; i < inGroups.size(); i++) {
			if (!(inGroup.contains(inGroups.get(i)))) {
				inGroup.add(inGroups.get(i));
			}

		}

		map.put("inGroups", inGroup);
		map.put("ownerG", ownerG);
		map.put("friend", user);

		return "user/viewfriend";

	}

	@RequestMapping(value = "user/viewProfile.html")
	public String viewProfile(ModelMap map, HttpServletRequest request,
			@RequestParam("userId") String fdId) {
		Integer id = Integer.parseInt(fdId);

		if (request.getSession().getAttribute("user") == null)
			return "redirect:../home.html";

		User user = userDao.getUser(id);

		List<Group> inGroup = new ArrayList<Group>();
		List<Group> ownerG = groupDao.getOwnerGroups(user);

		List<Group> inGroups = groupDao.getGroupsIamIn(new Group(), user);
		for (int i = 0; i < inGroups.size(); i++) {
			if (!(inGroup.contains(inGroups.get(i)))) {
				inGroup.add(inGroups.get(i));
			}

		}

		map.put("inGroups", inGroup);
		map.put("ownerG", ownerG);
		map.put("friend", user);

		return "user/viewProfile";

	}

	@RequestMapping(value = "user/unfollow.html", method = RequestMethod.GET)
	public String unfollow(@RequestParam("uid") Integer uid,
			@RequestParam("unfollow") Integer guid, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:../home.html";

		groupDao.unfriend(guid, uid);

		return "redirect:profile.html";
	}

}
