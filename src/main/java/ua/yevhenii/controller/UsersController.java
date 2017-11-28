package ua.yevhenii.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.yevhenii.service.UsersService;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Yevhenii on 25.11.2017.
 */
@Controller
//@RequestMapping("/main")
public class UsersController {
    @Resource(name="usersService")
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getPersons() {
        Map<String, List<String>> model = new HashMap<>();

        List users = usersService.getAll();
        model.put("list", users);
        return new ModelAndView("users", model);

    }
}
