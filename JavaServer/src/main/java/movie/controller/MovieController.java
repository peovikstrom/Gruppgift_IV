package movie.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.database.CinemaRepository;
import movie.entity.Movie;


@Controller
public class MovieController {

    @Autowired

    private CinemaRepository cinemaRepository;

    @GetMapping(value = "/movie")
    public String rootPage(Map<String, Object> model) {

        List<Movie> movielist = cinemaRepository.findAll();
        model.put("listmovies", cinemaRepository.findAll());
        System.out.println(movielist);
        return "movie";
    }


/*@Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/welcome")
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
    }*/


}