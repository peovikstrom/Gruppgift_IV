package movie.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import movie.database.ShowRepository;
import movie.entity.Show;
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

    @Autowired
    private ShowRepository showRepository;

    @GetMapping(value = "/movie")
    public String rootPage(Map<String, Object> model) {
        Movie movie = new Movie();
        movie.setTitle("My Little Pony");
        movie.setDescription("Friendship is magic");
        cinemaRepository.save(movie);
        Show show = new Show();
        show.setMovie(movie);
        showRepository.save(show);

        List<Movie> movielist = cinemaRepository.findAll();
        model.put("listmovies", cinemaRepository.findAll());
        List<Show> showList = showRepository.findAll();
        model.put("listshows", showRepository.findAll());
        System.out.println(movielist);
        System.out.println(showList);
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