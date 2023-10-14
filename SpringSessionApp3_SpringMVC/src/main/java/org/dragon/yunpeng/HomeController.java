package org.dragon.yunpeng;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "index";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring MVC");
		return "welcome";
	}

	@RequestMapping(value = "/saveSessionAttribute", method = RequestMethod.POST)
	protected String saveSessionAttribute(HttpServletRequest req) {
		String attributeName = req.getParameter("attributeName");
		String attributeValue = req.getParameter("attributeValue");
		req.getSession().setAttribute(attributeName, attributeValue);

		return "redirect:/";
	}
}
