package org.dragon.yunpeng.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dragon.yunpeng.pojo.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSessionController {

	@GetMapping("/")
	public String home(Model model, HttpSession session) {

		List<Pair> data = new ArrayList<Pair>();

		Enumeration<String> names = session.getAttributeNames();

		while (names.hasMoreElements()) {
			String attributeName = names.nextElement();
			Object attributeValue = session.getAttribute(attributeName);

			System.out.println("attributeName=" + attributeName);
			System.out.println("attributeValue=" + attributeValue);

			Pair pair = new Pair(attributeName, attributeValue);
			data.add(pair);

			model.addAttribute("sessionObjects", data);
		}

		return "index";
	}

	@PostMapping("/saveToSession")
	public String persistMessage(@RequestParam("attributeName") String attributeName,
			@RequestParam("attributeValue") String attributeValue, HttpServletRequest request) {

		request.getSession().setAttribute(attributeName, attributeValue);
		return "redirect:/";
	}

	@PostMapping("/destroySession")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}