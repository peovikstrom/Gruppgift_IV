package movie.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/")
    public String welcome(Map<String, Object> model, String query1) {

        model.put("time", new Date());
        model.put("message", message);
        return "welcome";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
    	String result = "FOO";
        model.put("message", result);
        return "welcome";
    }

}