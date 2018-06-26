package movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movie.database.MovieRepository;
import movie.database.ShowRepository;
import movie.database.TheatreRepository;
import movie.database.TicketRepository;
import movie.entity.Movie;
import movie.entity.Show;
import movie.entity.Theatre;
import movie.entity.Ticket;

@RestController
@RequestMapping({"/api"})
public class MainRestController {

	public MainRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private TheatreRepository theatreRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping(value = "/allmovies")
	public List<Movie> moviePage(Map<String, Object> model) {
		return movieRepository.findAll();
	}

	@GetMapping(value = "/test1")
	public Ticket indexPage1(Map<String, Object> model) {
		
		Show test = showRepository.findById(1);
		Movie testmov = movieRepository.findById(1);
		Theatre theatre = theatreRepository.findById(1);
		Ticket ticktest = ticketRepository.findById(2);
		
		return ticktest;
	}

	
	@GetMapping(value = "/allshows")
	//Comment
	public List<Show> indexPage2(Map<String, Object> model) {
		return showRepository.findAll();
	}

}
