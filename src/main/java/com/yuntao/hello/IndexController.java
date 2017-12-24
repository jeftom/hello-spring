package com.yuntao.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

/**
 * class description
 *
 * @author jeftom
 * @date 17/12/23 20:41
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {
	/**
	 * 默认首页方法
	 * 这里的 RequestMapping value 要写成空的，才能用 /hello 访问到
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("msg", "fuck Spring MVC mother index");
		model.addAttribute("name", "SpringMother");

		return "index";
	}
}
