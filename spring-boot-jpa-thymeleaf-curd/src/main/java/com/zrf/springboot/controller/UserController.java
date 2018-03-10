package com.zrf.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zrf.springboot.entity.User;
import com.zrf.springboot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "user/list";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "user/userAdd";
	}

	@RequestMapping("/add")
	public String add(User user) {
		userService.save(user);
		return "redirect:/list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, int id) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(User user) {
		userService.edit(user);
		return "redirect:/list";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		userService.delete(id);
		return "redirect:/list";
	}

}
