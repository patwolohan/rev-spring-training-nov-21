package ie.rc.SpringWebApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.rc.userdao.User;
import ie.rc.userdao.UserDao;
import ie.rc.userdao.UserDaoException;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDao dao;
	
	
	@RequestMapping("/")
	public String userList(Model model) {
		
		List<User> users = dao.getUsers();
		
		model.addAttribute("users", users);
		
		return "userlist";
	}
	
	@RequestMapping("/{id}")
	public String userDetails(Model model, @PathVariable("id") int id) {
		
		try {
			User u = dao.getUser(id);
			
			model.addAttribute("user", u);
			
		} catch (UserDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "userdetails";
	}
	
	
	
	@RequestMapping("/test")
	public String userListTest(Model model) {
		
		try {
			User u = dao.getUser(1);
			
			model.addAttribute("user", u);
			
		} catch (UserDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "showuser";
	}
	
}
