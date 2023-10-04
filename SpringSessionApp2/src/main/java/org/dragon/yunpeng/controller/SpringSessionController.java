package org.dragon.yunpeng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSessionController {

	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> objects = (List<String>) session.getAttribute("SESSION_OBJECTS");

		if (objects == null) {
			objects = new ArrayList<>();
		}
		model.addAttribute("sessionObjects", objects);

		return "index";
	}

	@PostMapping("/saveToSession")
	public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> objects = (List<String>) request.getSession().getAttribute("SESSION_OBJECTS");
		if (objects == null) {
			objects = new ArrayList<>();
			request.getSession().setAttribute("SESSION_OBJECTS", objects);
		}
		objects.add(msg);
		request.getSession().setAttribute("SESSION_OBJECTS", objects);
		return "redirect:/";
	}

	@PostMapping("/destroySession")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}