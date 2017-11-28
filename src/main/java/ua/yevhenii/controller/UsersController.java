package ua.yevhenii.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.yevhenii.dao.JdbcTemplateUserDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(){
        Map<String, List<String>> model = new HashMap<>();
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplateUserDaoImpl jdbcTemplateUserDao=
                (JdbcTemplateUserDaoImpl) context.getBean("jdbcTemplateUserDao");
        List users = jdbcTemplateUserDao.listUsers();
        model.put("list", users);
        return new ModelAndView("users", model);
    }
}
