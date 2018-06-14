package movie.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PostMapping("/foo")
    public String foo(Map<String, Object> model,
    		@RequestParam("seats") String nrSeats,
    		@RequestParam("movie") String movieId) {
    	
    	String result = "FOO";
        model.put("message", result);
        
        System.out.println("Seats: "+nrSeats);
        System.out.println("Movie ID:"+movieId);

        return "welcome";
    }

}