package ua.yevhenii.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.yevhenii.model.User;
import ua.yevhenii.service.UsersService;
import ua.yevhenii.sortingAlgorithms.Sorting;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Yevhenii on 25.11.2017.
 */
@Controller
//@RequestMapping("/main")
public class UsersController {
    @Resource(name = "usersService")
    private UsersService usersService;

    @RequestMapping(value = "/users/{sort}", method = RequestMethod.GET)
    public ModelAndView getInsertPersons(@PathVariable(name = "sort") String sort) {
        Map<String, List<String>> model = new HashMap<>();

        List users = usersService.getAll();
        model.put("list", users);
        User[] arr = new User[0];
        arr = (User[]) users.toArray(arr);
        switch (sort) {
            case "bubble":
                Sorting.bubbleSort(arr);
                break;
            case "insert":
                Sorting.insertSort(arr);
                break;
            default:
                Sorting.quickSort(arr);
                break;
        }

        List sortedList = new ArrayList();
        for (User user : arr) {
            sortedList.add(user);
        }
        model.put("sortedList", sortedList);
        return new ModelAndView("users", model);

    }

}
