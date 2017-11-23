package ua.yevhenii.servlet;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class SeviceREST {

    private static final String template = "Hello, %s!";

    @RequestMapping(value = "/getsomedata/{name}", method = RequestMethod.GET)
    protected String get(@PathVariable String name)  {
        return String.format(template, name);
    }

    @RequestMapping(value = "/gethello", method = RequestMethod.GET)
    protected String getHello() {
        return "Hello, world!";
    }
}
