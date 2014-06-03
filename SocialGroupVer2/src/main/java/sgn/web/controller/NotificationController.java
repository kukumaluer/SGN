package sgn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sgn.model.Notifications;
import sgn.model.User;
import sgn.model.dao.GroupDao;
import sgn.model.dao.NotificationsDao;
import sgn.model.dao.UserDao;


@Controller
public class NotificationController {
	
	@Autowired
	GroupDao groupDao;
	@Autowired
	NotificationsDao ntfDao;
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = { "user/notifications.html", "user/notifications"} )
	public String notification(ModelMap map,
			HttpServletRequest request )
	{

		if (request.getSession().getAttribute("user") == null)
			return "redirect:../home.html";
		
		
		
		return "user/notifications";
	}
	
	@RequestMapping(value = "user/approve.html")
	public String approve(@RequestParam("ntfIndex") Integer ntfIndex, 
						HttpServletRequest request)
	{
		User user =(User) request.getSession().getAttribute("user");
		
		userDao.update(user.getNotifications().get(ntfIndex).getFriendId(), user.getNotifications().get(ntfIndex).getGroudId());
		ntfDao.deleteNotification(user.getNotifications().get(ntfIndex));
		user.setNotifications(ntfDao.getNotifications(user));
		
		
		return "redirect:notifications.html";
	}
	
}