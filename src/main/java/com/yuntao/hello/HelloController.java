package com.yuntao.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by pengyuntao on 16/10/12.
 */
@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {
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

	/**
	 * FUCK方法
	 *
	 * @param model MAP模型
	 * @return string
	 */
	@RequestMapping(value = "/fuck", method = RequestMethod.GET)
	public String fuckOnce(ModelMap model) {
		model.addAttribute("msg", "fuck Spring MVC mother");
		model.addAttribute("name", "SpringMother");

		return "fuck";
	}

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
	    try {
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String pass = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		    String hashPass = passwordEncoder.encode(pass);
		    System.out.println("short" + hashPass);
		    System.out.println("long" + passwordEncoder.encode("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
		    boolean isMatch = passwordEncoder.matches("admin", "$2a$10$Bvedj8KIU23gw15JKwVrwOm2Vdm04fl2g8GIznm4JpBFt0tttFnYS");
		    System.out.println(isMatch);
	    } catch (Exception e) {
		    System.out.println(e.getMessage());
	    }

        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "yuntao");

        return "hello";
    }
}
