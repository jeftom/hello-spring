package com.yuntao.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pengyuntao on 16/10/12.
 */
@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "yuntao");
        return "hello";
    }

    @RequestMapping(value = "/fuck", method = RequestMethod.GET)
    public String fuckOnce(ModelMap model) {
        model.addAttribute("msg", "fuck Spring MVC mother");
        model.addAttribute("name", "SpringMother");

        return "fuck";
    }
}
