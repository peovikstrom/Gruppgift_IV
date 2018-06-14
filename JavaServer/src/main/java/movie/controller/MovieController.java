package movie.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    	List<Movie> movies = movieRepository.findAll();
    	List<Show> shows = showRepository.findAll();
    	
    	model.put("movies",movies);
    	//model.put("shows",shows);
    	
    	model.put("theatres",theatres);
    	model.put("show",shows.get(0));
    	
        return "index";
    }

    @GetMapping(value = "/index/{id}")
    public String indexPage(Map<String, Object> model, @PathVariable int id) {
    	
    	List<Theatre> theatres = theatreRepository.findAll();
    	List<Movie> movies = movieRepository.findAll();
    	List<Show> shows = showRepository.findAll();
    	
    	model.put("movies",movies);
    	//model.put("shows",shows);
    	
    	//model.put("theatres",theatres);
    	//model.put("show",shows.get(0));
    	
    	List<Show> showList = shows.stream()
    			.filter(b->b.getId()==id)
    			.collect(Collectors.toList());
    	
    	model.put("shows", showList);
    	System.out.println("Salong ID:"+id);
    	System.out.println(shows.get(0).getMovie());
        return "index";
    }
    
    @GetMapping(value = "/addMovie")
    public String addMoviePage (Map<String, Object> model) {	
    	return "addMovie";
    }
    
    @PostMapping("/addMoviePost")
    public String foo(Map<String, Object> model,
    		@RequestParam("title") String title,
    		@RequestParam("description") String description,
    		@RequestParam("url") String uriPoster){
    	
    	String result = "addMoviePost";
        model.put("message", result);
        
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setUriPoster(uriPoster);
        movieRepository.save(movie);
        
        System.out.println("Title: "+title);
        System.out.println("Desc:"+description);
        System.out.println("Url:"+uriPoster);
        
        return "redirect:index";
    }
    
    @GetMapping(value = "/addShow")
    public String addShowPage(Map<String, Object> model) {
    	
    	List<Movie> movies = movieRepository.findAll();
    	List<Show> shows = showRepository.findAll();
    	
    	model.put("movies",movies);
    	model.put("shows", shows);
    	
        return "addShow";
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