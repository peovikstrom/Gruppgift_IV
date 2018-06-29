package movie.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin
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

	@GetMapping(value = "/test1")
	public Ticket indexPageTest(Map<String, Object> model) {
		
		Show test = showRepository.findById(1);
		Movie testmov = movieRepository.findById(1);
		Theatre theatre = theatreRepository.findById(1);
		Ticket ticktest = ticketRepository.findById(2);
		
		return ticktest;
	}

	@GetMapping(value = "/allmovies")
	public List<Movie> moviePage(Map<String, Object> model) {
		return movieRepository.findAll();
	}

	@GetMapping(value = "/allshows")
	public List<Show> indexPage1(Map<String, Object> model) {
		return showRepository.findAll();
	}

	@GetMapping(value = "/alltickets")
	public List<Ticket> indexPage2(Map<String, Object> model) {
		return ticketRepository.findAll();
	}

	@GetMapping(value = "/alltheatre")
	public List<Theatre> indexPage3(Map<String, Object> model) {
		return theatreRepository.findAll();
	}

	@PostMapping(value = "/postmovie")
	public String postmovie(@RequestBody Movie movie){
		
		System.out.println("POST");
		System.out.println(movie);
		
		return "{\"ret\": \"MOVIE THROWN\"}";
	}
	
	@PostMapping(value = "/postshow")
	public String postshow(@RequestBody Show show){
		
		System.out.println("POST");
		System.out.println(show);
		
		return "{\"ret\": \"SHOW THROWN\"}";
	}
	
	@PostMapping(value = "/postticket")
	public String postticket(@RequestBody GreyTicket ticket){
		
		System.out.println("POST");
		
		System.out.println(ticket.showid);
		System.out.println(ticket.seatcol);
		System.out.println(ticket.seatrow);
		
		Ticket t = new Ticket();
		t.setSeatCol(ticket.seatcol);
		t.setSeatRow(ticket.seatrow);
		t.setShow( showRepository.findById(ticket.showid));
		
		ticketRepository.save(t);
		
		
		return "OK";
		//return "{\"ret\": \"SHOW THROWN\"}";
	}



}
