package movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import movie.database.MovieRepository;
import movie.database.ShowRepository;
import movie.database.TheatreRepository;
import movie.entity.Movie;
import movie.entity.Show;
import movie.entity.Theatre;


@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;
    
    @Autowired
    private TheatreRepository theatreRepository;

    @GetMapping(value = "/movie")
    public String rootPage(Map<String, Object> model) {
        Movie movie = new Movie();
        movie.setTitle("My Little Pony");
        movie.setDescription("Friendship is magic");
        movieRepository.save(movie);
        Show show = new Show();
        show.setMovie(movie);
        showRepository.save(show);
        List<Movie> movielist = movieRepository.findAll();
        model.put("listmovies", movieRepository.findAll());
        List<Show> showList = showRepository.findAll();
        model.put("listshows", showRepository.findAll());
        System.out.println(movielist);
        System.out.println(showList);
        return "movie";
    }

    @GetMapping(value = "/index")
    public String indexPage(Map<String, Object> model) {
    	List<Theatre> theatres = theatreRepository.findAll();
    	model.put("theatres",theatres);
        return "index";
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